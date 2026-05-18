package com.aldirneto.mygamerboxd.repository;
import com.aldirneto.mygamerboxd.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    //Buscar um usuário pelo email
    Optional<Usuario>findByEmail(string email)
    //Retorna se o username estiver em uso no banco
    boolean existsByUsername(stringusername);
}