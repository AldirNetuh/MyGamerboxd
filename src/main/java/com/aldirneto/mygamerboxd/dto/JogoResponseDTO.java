package com.aldirneto.mygamerboxd.dto;
import lombok.Data;
import java.math.BigDecimal;
@Data
public class JogoResponseDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private BigDecimal notaMedia;
}