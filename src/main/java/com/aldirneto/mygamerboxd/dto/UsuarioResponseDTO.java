package com.aldirneto.mygamerboxd.dto;
public record UsuarioResponseDTO(
    Long id,
    String username,
    String email,
    String tipoUsuario
) {}