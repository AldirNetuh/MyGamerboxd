package com.aldirneto.mygamerboxd.dto;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
public record ReviewRequestDTO(
    @NotNull(message = "A nota é obrigatória.")
    @Min(value = 0, message = "A nota mínima é 0.")
    @Max(value = 10, message = "A nota máxima é 10.")
    BigDecimal nota,

    String texto,

    @NotNull(message = "O ID do jogo é obrigatório.")
    Long jogoId,

    @NotNull(message = "O ID do usuário é obrigatório.")
    Long usuarioId
) {}