package com.aldirneto.mygamerboxd.repository;
import com.aldirneto.mygamerboxd.entity.Genero;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface GeneroRepository extends CrudRepository<Genero, Long>{

}