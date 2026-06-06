package com.aldirneto.mygamerboxd.controller;

import com.aldirneto.mygamerboxd.dto.GeneroRequestDTO;
import com.aldirneto.mygamerboxd.service.GeneroService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@WebMvcTest(GeneroController.class)
class GeneroControllerTest {
    @Autowired private MockMvc mvc;
    @MockBean private GeneroService service;
    @Autowired private ObjectMapper om;

    @Test
    void deveListarTodos() throws Exception {
        when(service.listarTodos()).thenReturn(Collections.emptyList());
        mvc.perform(get("/api/generos")).andExpect(status().isOk());
    }

    @Test
    void deveCriar() throws Exception {
        GeneroRequestDTO req = new GeneroRequestDTO("RPG");
        mvc.perform(post("/api/generos").contentType(MediaType.APPLICATION_JSON)
            .content(om.writeValueAsString(req))).andExpect(status().isCreated());
    }
}