package com.aldirneto.mygamerboxd.repository;

import com.aldirneto.mygamerboxd.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByJogoId(Long jogoId);

    List<Review> findByUsuarioId(Long usuarioId);
}