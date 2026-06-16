package com.aldirneto.mygamerboxd.controller;

import com.aldirneto.mygamerboxd.dto.UsuarioRequestDTO;
import com.aldirneto.mygamerboxd.dto.UsuarioResponseDTO;
import com.aldirneto.mygamerboxd.exception.ResourceNotFoundException;
import com.aldirneto.mygamerboxd.service.UsuarioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UsuarioControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UsuarioService service;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveRetornar201AoCadastrar() throws Exception {
        UsuarioRequestDTO req = new UsuarioRequestDTO("aldir", "aldir@test.com", "123", "ADMIN", "CHAVE");
        UsuarioResponseDTO res = new UsuarioResponseDTO(1L, "aldir", "aldir@test.com", "ADMIN");
        when(service.cadastrar(any(UsuarioRequestDTO.class))).thenReturn(res);
        mockMvc.perform(post("/api/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.username").value("aldir"));
    }

    @Test
    void deveRetornar404QuandoNaoEncontrar() throws Exception {
        when(service.buscarPorId(99L)).thenThrow(new ResourceNotFoundException("Usuário não encontrado."));

        mockMvc.perform(get("/api/usuarios/99"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.status").value(404));
    }
}