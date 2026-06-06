package com.aldirneto.mygamerboxd.service;

import com.aldirneto.mygamerboxd.dto.UsuarioRequestDTO;
import com.aldirneto.mygamerboxd.dto.UsuarioResponseDTO;
import com.aldirneto.mygamerboxd.entity.Admin;
import com.aldirneto.mygamerboxd.entity.Jogador;
import com.aldirneto.mygamerboxd.entity.Usuario;
import com.aldirneto.mygamerboxd.exception.ResourceNotFoundException;
import com.aldirneto.mygamerboxd.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    private UsuarioResponseDTO converterParaDTO(Usuario usuario) {
        String tipo = usuario instanceof Admin ? "ADMIN" : "JOGADOR";
        return new UsuarioResponseDTO(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getEmail(),
                tipo
        );
    }
    @Transactional(readOnly = true)
    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository.findAll().stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }
    @Transactional(readOnly = true)
    public UsuarioResponseDTO buscarPorId(Long id) {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuário não encontrado."));
        return converterParaDTO(usuario);
    }
    @Transactional
    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO dto) {
        Usuario usuario;
        if ("ADMIN".equalsIgnoreCase(dto.tipoUsuario())) {
            Admin admin = new Admin();
            admin.setChaveSeguranca(dto.chaveSeguranca());
            usuario = admin;
        } else {
            Jogador jogador = new Jogador();
            usuario = jogador;
        }
        usuario.setUsername(dto.username());
        usuario.setEmail(dto.email());
        usuario.setSenha(dto.senha()); 
        return converterParaDTO(usuarioRepository.save(usuario));
    }
    @Transactional
    public void deletar(Long id) {
        usuarioRepository.deleteById(id);
    }
}