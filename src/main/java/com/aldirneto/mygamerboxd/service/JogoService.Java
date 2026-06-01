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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    private JogoResponseDTO converterParaDTO(Jogo jogo) {
        JogoResponseDTO dto = new JogoResponseDTO();
        dto.setId(jogo.getId());
        dto.setTitulo(jogo.getTitulo());
        dto.setDescricao(jogo.getDescricao());
        dto.setNotaMedia(jogo.getNotaMedia());
        return dto;
    }

    @Transactional(readOnly = true)
    public List<JogoResponseDTO> listarTodos() {
        return jogoRepository.findAll().stream().map(this::converterParaDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public JogoResponseDTO buscarPorId(Long id) {
        Jogo jogo = jogoRepository.findById(id)
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
        Jogo jogo = jogoRepository.findById(id)
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

    // Isola a lógica para respeitar DRY (Don't Repeat Yourself)
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