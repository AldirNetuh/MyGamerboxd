package com.aldirneto.mygamerboxd.dto;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.util.Set;
@Data
public class JogoRequestDTO {  
    @NotBlank(message = "O título do jogo é obrigatório.")
    private String titulo;
    private String descricao;
    private Set<Long> generosIds;
    private Set<Long> plataformasIds;
}