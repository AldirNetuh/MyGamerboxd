package com.aldirneto.mygamerboxd.repository;

import com.aldirneto.mygamerboxd.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface JogoRepository extends JpaRepository<Jogo, Long> {

    @Query("SELECT j FROM Jogo j LEFT JOIN FETCH j.reviews WHERE j.id = :id")
    Optional<Jogo> findByIdWithReviews(@Param("id") Long id);

    @Query("SELECT DISTINCT j FROM Jogo j LEFT JOIN FETCH j.reviews")
    List<Jogo> findAllWithReviews();

    List<Jogo> findByTituloContainingIgnoreCase(String titulo);
}