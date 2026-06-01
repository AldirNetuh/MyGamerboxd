package com.aldirneto.mygamerboxd.service;

import com.aldirneto.mygamerboxd.dto.JogoRequestDTO;
import com.aldirneto.mygamerboxd.dto.JogoResponseDTO;
import com.aldirneto.mygamerboxd.entity.Genero;
import com.aldirneto.mygamerboxd.entity.Jogo;
import com.aldirneto.mygamerboxd.entity.Plataforma;
import com.aldirneto.mygamerboxd.exception.ResourceNotFoundException;
import com.aldirneto.mygamerboxd.repository.GeneroRepository;
import com.aldirneto.mygamerboxd.repository.JogoRepository;
import com.aldirneto.mygamerboxd.repository.PlataformaRepository;
import com.aldirneto.mygamerboxd.strategy.CalculadoraScore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JogoService {

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private GeneroRepository generoRepository;

    @Autowired
    private PlataformaRepository plataformaRepository;

   @Autowired
    @org.springframework.beans.factory.annotation.Qualifier("calculoAritmetico")
    private CalculadoraScore calculadoraScore;

    private JogoResponseDTO converterParaDTO(Jogo jogo) {
        JogoResponseDTO dto = new JogoResponseDTO();
        dto.setId(jogo.getId());
        dto.setTitulo(jogo.getTitulo());
        dto.setDescricao(jogo.getDescricao());
        
        BigDecimal media = calculadoraScore.calcular(jogo.getReviews());
        dto.setNotaMedia(media);
        
        return dto;
    }

    @Transactional(readOnly = true)
    public List<JogoResponseDTO> listarTodos() {
        // Força a busca trazendo as reviews associadas
        return jogoRepository.findAllWithReviews().stream().map(this::converterParaDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public JogoResponseDTO buscarPorId(Long id) {
        // Força a busca trazendo as reviews associadas
        Jogo jogo = jogoRepository.findByIdWithReviews(id)
                .orElseThrow(() -> new ResourceNotFoundException("Jogo não encontrado."));
        return converterParaDTO(jogo);
    }

    @Transactional(readOnly = true)
    public List<JogoResponseDTO> buscarPorTitulo(String titulo) {
        return jogoRepository.findByTituloContainingIgnoreCase(titulo).stream()
                .map(this::converterParaDTO).collect(Collectors.toList());
    }

    @Transactional
    public JogoResponseDTO criar(JogoRequestDTO dto) {
        Jogo jogo = new Jogo();
        jogo.setTitulo(dto.getTitulo());
        jogo.setDescricao(dto.getDescricao());
        
        vincularRelacionamentos(jogo, dto);

        return converterParaDTO(jogoRepository.save(jogo));
    }

    @Transactional
    public JogoResponseDTO atualizar(Long id, JogoRequestDTO dto) {
        Jogo jogo = jogoRepository.findByIdWithReviews(id)
                .orElseThrow(() -> new ResourceNotFoundException("Jogo não encontrado."));
        
        jogo.setTitulo(dto.getTitulo());
        jogo.setDescricao(dto.getDescricao());
        
        vincularRelacionamentos(jogo, dto);

        return converterParaDTO(jogoRepository.save(jogo));
    }

    @Transactional
    public void deletar(Long id) {
        jogoRepository.deleteById(id);
    }

    private void vincularRelacionamentos(Jogo jogo, JogoRequestDTO dto) {
        if (dto.getGenerosIds() != null && !dto.getGenerosIds().isEmpty()) {
            List<Genero> generos = generoRepository.findAllById(dto.getGenerosIds());
            jogo.setGeneros(new HashSet<>(generos));
        }

        if (dto.getPlataformasIds() != null && !dto.getPlataformasIds().isEmpty()) {
            List<Plataforma> plataformas = plataformaRepository.findAllById(dto.getPlataformasIds());
            jogo.setPlataformas(new HashSet<>(plataformas));
        }
    }
}