package com.aldirneto.mygamerboxd.service;
import com.aldirneto.mygamerboxd.dto.ReviewRequestDTO;
import com.aldirneto.mygamerboxd.dto.ReviewResponseDTO;
import com.aldirneto.mygamerboxd.entity.Jogo;
import com.aldirneto.mygamerboxd.entity.Review;
import com.aldirneto.mygamerboxd.entity.Usuario;
import com.aldirneto.mygamerboxd.exception.ResourceNotFoundException;
import com.aldirneto.mygamerboxd.repository.JogoRepository;
import com.aldirneto.mygamerboxd.repository.ReviewRepository;
import com.aldirneto.mygamerboxd.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private JogoRepository jogoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    private ReviewResponseDTO converterParaDTO(Review review) {
        return new ReviewResponseDTO(
                review.getId(),
                review.getNota(),
                review.getTexto(),
                review.getJogo().getId(),
                review.getUsuario().getUsername()
        );
    }
    @Transactional(readOnly = true)
    public List<ReviewResponseDTO> listarTodas() {
        return reviewRepository.findAll().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public List<ReviewResponseDTO> listarPorJogo(Long jogoId) {
        return reviewRepository.findByJogoId(jogoId).stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }
    @Transactional
    public ReviewResponseDTO criar(ReviewRequestDTO dto) {
        Jogo jogo = jogoRepository.findById(dto.jogoId())
                .orElseThrow(() -> new ResourceNotFoundException("Jogo não encontrado."));      
        Usuario usuario = usuarioRepository.findById(dto.usuarioId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));
        Review review = new Review();
        review.setNota(dto.nota());
        review.setTexto(dto.texto());
        review.setJogo(jogo);
        review.setUsuario(usuario);
        return converterParaDTO(reviewRepository.save(review));
    }
    @Transactional
    public void deletar(Long id) {
        reviewRepository.deleteById(id);
    }
}