package com.aldirneto.mygamerboxd.dto;
import jakarta.validation.constraints.NotBlank;
public record GeneroRequestDTO(
    @NotBlank(message = "O nome da categoria é obrigatório e não pode estar em branco.")
    String nome
) {}