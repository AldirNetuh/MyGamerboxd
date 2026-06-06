package com.aldirneto.mygamerboxd.dto;
import java.math.BigDecimal;
public record ReviewResponseDTO(
    Long id,
    BigDecimal nota,
    String texto,
    Long jogoId,
    String usernameUsuario
) {}