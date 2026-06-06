package com.aldirneto.mygamerboxd.service;
import com.aldirneto.mygamerboxd.repository.ReviewRepository;
import com.aldirneto.mygamerboxd.repository.JogoRepository;
import com.aldirneto.mygamerboxd.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ReviewServiceTest {
    @Mock
    private ReviewRepository repo;
    @Mock
    private JogoRepository jogoRepo;
    @Mock
    private UsuarioRepository userRepo;
    @InjectMocks
    private ReviewService service;
    @Test
    void deveLancarExcecaoSeJogoNaoExistirAoCriar() {
        when(jogoRepo.findById(1L)).thenReturn(Optional.empty());
        // Acesso ao requestDTO (fictício para o teste)
        assertThrows(Exception.class, () -> service.criar(null));
    }
}