package com.aldirneto.mygamerboxd.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class PlataformaRequestDTO {
    @NotBlank(message = "O nome da plataforma é obrigatório.")
    private String nome;
}