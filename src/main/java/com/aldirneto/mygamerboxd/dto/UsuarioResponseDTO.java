package com.aldirneto.mygamerboxd.dto;
import lombok.Data;
@Data
public class UsuarioResponseDTO {
    private Long id;
    private String username;
    private String email;
    private String tipoUsuario;
}