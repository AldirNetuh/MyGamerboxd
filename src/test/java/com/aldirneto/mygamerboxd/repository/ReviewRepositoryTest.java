package com.aldirneto.mygamerboxd.repository;

import com.aldirneto.mygamerboxd.entity.Review;
import com.aldirneto.mygamerboxd.entity.Jogo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.math.BigDecimal;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class ReviewRepositoryTest {

    @Autowired
    private ReviewRepository repo;

    @Autowired
    private JogoRepository jogoRepo;

    @Test
    void deveListarReviewsPorJogo() {
        Jogo jogo = new Jogo();
        jogo.setTitulo("Dark Souls");
        jogo = jogoRepo.save(jogo);

        Review r = new Review();
        r.setNota(new BigDecimal("9.99"));
        r.setJogo(jogo);
        
        repo.save(r);
        
        assertThat(repo.findByJogoId(jogo.getId())).hasSize(1);
    }
}