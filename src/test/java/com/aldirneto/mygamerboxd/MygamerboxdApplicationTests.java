package com.aldirneto.mygamerboxd;

import com.aldirneto.mygamerboxd.strategy.CalculoAritmetico;
import com.aldirneto.mygamerboxd.strategy.CalculoPonderado;
import com.aldirneto.mygamerboxd.entity.Admin;
import java.util.Arrays;
import java.util.ArrayList;
import com.aldirneto.mygamerboxd.entity.Jogador;
import com.aldirneto.mygamerboxd.entity.Jogo;
import com.aldirneto.mygamerboxd.entity.Review;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MygamerboxdApplicationTests {

    @Test
    void deveInstanciarJogoEValidarAtributosLombok() {
        Jogo jogo = new Jogo();
        jogo.setTitulo("The Witcher 3");
        jogo.setDescricao("RPG de mundo aberto");
        jogo.setNotaMedia(new BigDecimal("9.80"));

        assertEquals("The Witcher 3", jogo.getTitulo());
        assertEquals("RPG de mundo aberto", jogo.getDescricao());
        assertEquals(new BigDecimal("9.80"), jogo.getNotaMedia());
        assertNotNull(jogo.getGeneros());
        assertNotNull(jogo.getPlataformas());
        assertNotNull(jogo.getReviews());
    }

    @Test
    void deveAdicionarReviewNaListaDoJogo() {
        Jogo jogo = new Jogo();
        Review review = new Review(); 
        
        jogo.getReviews().add(review);

        assertEquals(1, jogo.getReviews().size());
        assertFalse(jogo.getReviews().isEmpty());
    }

    @Test
    void deveInstanciarJogadorGarantindoHeranca() {
        Jogador jogador = new Jogador();
        assertNotNull(jogador);
    }
	@Test
    void calculoAritmeticoDeveRetornarZeroSeListaVaziaOuNula() {
        CalculoAritmetico calculo = new CalculoAritmetico();
        assertEquals(BigDecimal.ZERO, calculo.calcular(null));
        assertEquals(BigDecimal.ZERO, calculo.calcular(new ArrayList<>()));
    }

    @Test
    void calculoAritmeticoDeveCalcularMediaCorreta() {
        CalculoAritmetico calculo = new CalculoAritmetico();
        
        Review r1 = new Review();
        r1.setNota(new BigDecimal("8.0"));
        Review r2 = new Review();
        r2.setNota(new BigDecimal("10.0"));
        
        assertEquals(new BigDecimal("9.00"), calculo.calcular(Arrays.asList(r1, r2)));
    }

    @Test
    void calculoPonderadoDeveRetornarZeroSeListaVaziaOuNula() {
        CalculoPonderado calculo = new CalculoPonderado();
        assertEquals(BigDecimal.ZERO, calculo.calcular(null));
        assertEquals(BigDecimal.ZERO, calculo.calcular(new ArrayList<>()));
    }

    @Test
    void calculoPonderadoDeveCalcularMediaComPesoMaiorParaAdmin() {
        CalculoPonderado calculo = new CalculoPonderado();

        Review reviewAdmin = new Review();
        reviewAdmin.setNota(new BigDecimal("10.0"));
        reviewAdmin.setUsuario(new Admin());
		
		Review reviewJogador = new Review();
        reviewJogador.setNota(new BigDecimal("7.0"));
        reviewJogador.setUsuario(new Jogador());
        assertEquals(new BigDecimal("9.00"), calculo.calcular(Arrays.asList(reviewAdmin, reviewJogador)));
    }
}