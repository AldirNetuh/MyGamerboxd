package com.aldirneto.mygamerboxd.dto;
import jakarta.validation.constraints.NotBlank;
public record PlataformaRequestDTO(
    @NotBlank(message = "O nome da plataforma é obrigatório.")
    String nome
) {}