package com.aldirneto.mygamerboxd.service;
import com.aldirneto.mygamerboxd.repository.JogoRepository;
import com.aldirneto.mygamerboxd.exception.ResourceNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class JogoServiceTest {
    @Mock
    private JogoRepository repo;
    @InjectMocks
    private JogoService service;
    @Test
    void deveLancarExcecaoSeJogoNaoExistir() {
        when(repo.findByIdWithReviews(1L)).thenReturn(Optional.empty());
        assertThrows(ResourceNotFoundException.class, () -> service.buscarPorId(1L));
    }
}