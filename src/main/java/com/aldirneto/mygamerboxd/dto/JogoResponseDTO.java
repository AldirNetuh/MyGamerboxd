package com.aldirneto.mygamerboxd.dto;
import java.math.BigDecimal;
public record JogoResponseDTO(
    Long id,
    String titulo,
    String descricao,
    BigDecimal notaMedia
) {}