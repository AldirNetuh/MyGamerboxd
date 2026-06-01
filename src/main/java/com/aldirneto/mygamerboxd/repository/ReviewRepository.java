package com.aldirneto.mygamerboxd.repository;

import com.aldirneto.mygamerboxd.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    
    // Traz todas as avaliações para o jogo
    List<Review> findByJogoId(Long jogoId);
    
    // Traz todas as avaliações feitas por um usuário específico
    List<Review> findByUsuarioId(Long usuarioId);
}