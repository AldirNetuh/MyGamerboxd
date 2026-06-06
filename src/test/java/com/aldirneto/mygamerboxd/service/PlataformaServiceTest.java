package com.aldirneto.mygamerboxd.service;
import com.aldirneto.mygamerboxd.exception.ResourceNotFoundException;
import com.aldirneto.mygamerboxd.repository.PlataformaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PlataformaServiceTest {

    @Mock
    private PlataformaRepository repository;

    @InjectMocks
    private PlataformaService service;

    @Test
    void deveLancarExcecaoQuandoBuscarIdInexistente() {
        when(repository.findById(99L)).thenReturn(Optional.empty());

        assertThrows(ResourceNotFoundException.class, () -> service.buscarPorId(99L));
        verify(repository).findById(99L);
    }
}