package com.aldirneto.mygamerboxd.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
public record UsuarioRequestDTO(
    @NotBlank(message = "O username é obrigatório.") 
    String username,
    
    @NotBlank(message = "O email é obrigatório.") 
    @Email(message = "O email deve ser válido.") 
    String email,

    @NotBlank(message = "A senha é obrigatória.") 
    String senha,
    
    @NotBlank(message = "O tipo de usuário é obrigatório.") 
    @Pattern(regexp = "JOGADOR|ADMIN", message = "O tipo deve ser JOGADOR ou ADMIN.") 
    String tipoUsuario,
    String chaveSeguranca
) {}