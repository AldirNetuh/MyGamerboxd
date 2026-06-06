package com.aldirneto.mygamerboxd.controller;

import com.aldirneto.mygamerboxd.dto.ReviewRequestDTO;
import com.aldirneto.mygamerboxd.service.ReviewService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReviewController.class)
public class ReviewControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ReviewService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void deveRetornar201AoCriarReview() throws Exception {
        ReviewRequestDTO req = new ReviewRequestDTO(new BigDecimal("9.99"), "Bom", 1L, 1L);

        mockMvc.perform(post("/api/reviews")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(req)))
                .andExpect(status().isCreated());
    }
}