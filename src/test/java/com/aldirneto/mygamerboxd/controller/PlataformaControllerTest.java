package com.aldirneto.mygamerboxd.controller;

import com.aldirneto.mygamerboxd.dto.PlataformaRequestDTO;
import com.aldirneto.mygamerboxd.service.PlataformaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
class PlataformaControllerTest {
    @Autowired private MockMvc mockMvc;
    @Autowired private ObjectMapper om;

    @MockBean private PlataformaService service;

    @Test
    void deveListarTodas() throws Exception {
        when(service.listarTodas()).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/api/plataformas")).andExpect(status().isOk());
    }

    @Test
    void deveCriar() throws Exception {
        PlataformaRequestDTO req = new PlataformaRequestDTO("PC");
        mockMvc.perform(post("/api/plataformas").contentType(MediaType.APPLICATION_JSON)
            .content(om.writeValueAsString(req))).andExpect(status().isCreated());
    }
}