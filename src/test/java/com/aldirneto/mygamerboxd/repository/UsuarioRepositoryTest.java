package com.aldirneto.mygamerboxd.repository;
import com.aldirneto.mygamerboxd.entity.Jogador;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UsuarioRepositoryTest {
    @Autowired
    private UsuarioRepository repository;
    @Test
    void deveRetornarTrueQuandoUsernameExistir() {
        Jogador jogador = new Jogador();
        jogador.setUsername("teste.user");
        jogador.setEmail("teste@email.com");
        jogador.setSenha("123456");
        repository.save(jogador);

        boolean existe = repository.existsByUsername("teste.user");
        assertThat(existe).isTrue();
    }
    @Test
    void deveEncontrarUsuarioPorEmail() {
        Jogador jogador = new Jogador();
        jogador.setUsername("teste.email");
        jogador.setEmail("alvo@email.com");
        jogador.setSenha("123456");
        repository.save(jogador);
        var resultado = repository.findByEmail("alvo@email.com");
        assertThat(resultado).isPresent();
    }
}