package com.aldirneto.mygamerboxd.dto;
import jakarta.validation.constraints.NotBlank;
import java.util.Set;
public record JogoRequestDTO(
    @NotBlank(message = "O título do jogo é obrigatório.")
    String titulo,
    String descricao,
    Set<Long> generosIds,
    Set<Long> plataformasIds
) {}