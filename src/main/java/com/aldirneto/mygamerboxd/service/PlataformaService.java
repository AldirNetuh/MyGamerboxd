package com.aldirneto.mygamerboxd.service;

import com.aldirneto.mygamerboxd.dto.PlataformaRequestDTO;
import com.aldirneto.mygamerboxd.dto.PlataformaResponseDTO;
import com.aldirneto.mygamerboxd.entity.Plataforma;
import com.aldirneto.mygamerboxd.repository.PlataformaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlataformaService {

    @Autowired
    private PlataformaRepository plataformaRepository;

    private PlataformaResponseDTO converterParaDTO(Plataforma plataforma) {
        PlataformaResponseDTO dto = new PlataformaResponseDTO();
        dto.setId(plataforma.getId());
        dto.setNome(plataforma.getNome());
        return dto;
    }

    @Transactional(readOnly = true)
    public List<PlataformaResponseDTO> listarTodas() {
        return plataformaRepository.findAll().stream().map(this::converterParaDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PlataformaResponseDTO buscarPorId(Long id) {
        Plataforma plataforma = plataformaRepository.findById(id).orElseThrow(() -> new ResourcNotFoundException("Plataforma não encontrada."));
        return converterParaDTO(plataforma);
    }

    @Transactional
    public PlataformaResponseDTO criar(PlataformaRequestDTO dto) {
        Plataforma plataforma = new Plataforma();
        plataforma.setNome(dto.getNome());
        return converterParaDTO(plataformaRepository.save(plataforma));
    }

    @Transactional
    public PlataformaResponseDTO atualizar(Long id, PlataformaRequestDTO dto) {
        Plataforma plataforma = plataformaRepository.findById(id).orElseThrow(() -> new ResourcNotFoundException("Plataforma não encontrada."));
        plataforma.setNome(dto.getNome());
        return converterParaDTO(plataformaRepository.save(plataforma));
    }

    @Transactional
    public void deletar(Long id) {
        plataformaRepository.deleteById(id);
    }
}