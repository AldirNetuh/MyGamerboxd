package com.aldirneto.mygamerboxd.repository;
import com.aldirneto.mygamerboxd.entity.Genero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface GeneroRepository extends CrudRepository<Genero, Long>{
    //Buscar uma categoria pelo nome exato
    Optional<Genero> findByNomeIgnoreCase(String nome);
}