package com.aldirneto.mygamerboxd.repository;
import com.aldirneto.mygamerboxd.entity.Genero;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class GeneroRepositoryTest {
    @Autowired
    private GeneroRepository repo;
    @Test
    void deveSalvarEBuscarGenero() {
        Genero g = new Genero();
        g.setNome("RPG");
        repo.save(g);
        assertThat(repo.findById(g.getId())).isPresent();
    }
}