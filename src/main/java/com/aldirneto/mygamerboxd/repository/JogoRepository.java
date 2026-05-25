package com.aldirneto.mygamerboxd.repository;
import com.aldirneto.mygamerboxd.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.BigDecimal;
@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long>{
    //Buscar Jogo com a palavra do título
    List<Jogo> findByTituloCOntainingIgnorecase(String titulo)
    //Buscar Por Nota maior ou igual ao valor informado
    List<Jogo>findByNotaMediaGreaterThanEqual(BigDecimal nota);
}