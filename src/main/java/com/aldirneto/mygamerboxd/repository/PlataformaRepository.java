package com.aldirneto.mygamerboxd.repository;
import com.aldirneto.mygamerboxd.entity.Plataforma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
@Repository
public interface PlataformaRepository extends JpaRepository<Plataforma, Long>{
    Opitional<PLataforma> findByNomeIgnoreCase(String Nome);
}