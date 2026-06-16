package com.aldirneto.mygamerboxd.repository;
import com.aldirneto.mygamerboxd.entity.Plataforma;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class PlataformaRepositoryTest {
    @Autowired
    private PlataformaRepository repo;
    @Test
    void deveEncontrarPorNomeIgnorandoCase() {
        Plataforma p = new Plataforma();
        p.setNome("PC");
        repo.save(p);
        assertThat(repo.findByNomeIgnoreCase("pc")).isPresent();
    }
}