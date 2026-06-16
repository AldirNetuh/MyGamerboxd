package com.aldirneto.mygamerboxd.controller;

import com.aldirneto.mygamerboxd.dto.JogoRequestDTO;
import com.aldirneto.mygamerboxd.service.JogoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import java.util.Set;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class JogoControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper objectMapper;

    @MockBean private JogoService service;

    @Test
    void deveListarTodos() throws Exception {
        when(service.listarTodos()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/api/jogos")).andExpect(status().isOk());
    }

    @Test
    void deveCriar() throws Exception {
        JogoRequestDTO req = new JogoRequestDTO("Elden Ring", "RPG", Set.of(1L), Set.of(1L));
        mockMvc.perform(post("/api/jogos").contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(req))).andExpect(status().isCreated());
    }
}