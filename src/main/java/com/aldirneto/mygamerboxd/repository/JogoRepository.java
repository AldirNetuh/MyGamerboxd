package com.aldirneto.mygamerboxd.repository;

import com.aldirneto.mygamerboxd.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {
    
    // Buscar Jogo com a palavra do título
    List<Jogo> findByTituloContainingIgnoreCase(String titulo);
    
    // Buscar Por Nota maior ou igual ao valor informado
    List<Jogo> findByNotaMediaGreaterThanEqual(BigDecimal nota);
}