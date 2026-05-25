package com.aldirneto.mygamerboxd.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class GeneroRequestDTO {
    
    @NotBlank(message = "O nome da categoria é obrigatório e não pode estar em branco.")
    private String nome;
}