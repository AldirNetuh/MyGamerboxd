package com.aldirneto.mygamerboxd.repository;
import com.aldirneto.mygamerboxd.entity.Jogo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class JogoRepositoryTest {
    @Autowired
    private JogoRepository repo;
    @Test
    void deveBuscarPorTituloIgnorandoCase() {
        Jogo jogo = new Jogo();
        jogo.setTitulo("The Witcher");
        repo.save(jogo);
        assertThat(repo.findByTituloContainingIgnoreCase("witcher")).hasSize(1);
    }
}