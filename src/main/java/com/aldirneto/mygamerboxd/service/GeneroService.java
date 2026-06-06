package com.aldirneto.mygamerboxd.service;

import com.aldirneto.mygamerboxd.dto.GeneroRequestDTO;
import com.aldirneto.mygamerboxd.dto.GeneroResponseDTO;
import com.aldirneto.mygamerboxd.entity.Genero;
import com.aldirneto.mygamerboxd.exception.ResourceNotFoundException;
import com.aldirneto.mygamerboxd.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    private GeneroResponseDTO converterParaDTO(Genero genero) {
        return new GeneroResponseDTO(
                genero.getId(),
                genero.getNome()
        );
    }

    @Transactional(readOnly = true)
    public List<GeneroResponseDTO> listarTodos() {
        return generoRepository.findAll().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public GeneroResponseDTO buscarPorId(Long id) {
        Genero genero = generoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gênero não encontrado."));
        return converterParaDTO(genero);
    }

    @Transactional
    public GeneroResponseDTO criar(GeneroRequestDTO dto) {
        Genero genero = new Genero();
        genero.setNome(dto.nome());
        return converterParaDTO(generoRepository.save(genero));
    }

    @Transactional
    public GeneroResponseDTO atualizar(Long id, GeneroRequestDTO dto) {
        Genero genero = generoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Gênero não encontrado."));
        genero.setNome(dto.nome());
        return converterParaDTO(generoRepository.save(genero));
    }

    @Transactional
    public void deletar(Long id) {
        generoRepository.deleteById(id);
    }
}