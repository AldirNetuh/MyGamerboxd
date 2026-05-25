package com.aldirneto.mygamerboxd.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
@Data
public class UsuarioRequestDTO {
    @NotBlank(message = "O username é obrigatório.")
    private String username;
    @NotBlank(message = "O email é obrigatório.")
    @Email(message = "O email deve ser válido.")
    private String email;
    @NotBlank(message = "A senha é obrigatória.")
    private String senha;
    @NotBlank(message = "O tipo de usuário é obrigatório.")
    @Pattern(regexp = "JOGADOR|ADMIN", message = "O tipo deve ser JOGADOR ou ADMIN.")
    private String tipoUsuario;
    private String chaveSeguranca; 
}