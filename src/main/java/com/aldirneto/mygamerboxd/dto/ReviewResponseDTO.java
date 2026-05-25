package com.aldirneto.mygamerboxd.dto;
import lombok.Data;
import java.math.BigDecimal;
@Data
public class ReviewResponseDTO {
    private Long id;
    private BigDecimal nota;
    private String texto;
    private Long jogoId;
    private String usernameUsuario;
}