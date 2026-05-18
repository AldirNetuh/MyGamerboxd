package com.aldirneto.mygamerboxd.repository;
import com.aldirneto.mygamerboxd.entity.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;
@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long>{

}