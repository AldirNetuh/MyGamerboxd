package com.aldirneto.mygamerboxd.controller;

import com.aldirneto.mygamerboxd.dto.ReviewRequestDTO;
import com.aldirneto.mygamerboxd.dto.ReviewResponseDTO;
import com.aldirneto.mygamerboxd.service.ReviewService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<ReviewResponseDTO>> listarTodas() {
        return ResponseEntity.ok(reviewService.listarTodas());
    }

    @GetMapping("/jogo/{jogoId}")
    public ResponseEntity<List<ReviewResponseDTO>> listarPorJogo(@PathVariable Long jogoId) {
        return ResponseEntity.ok(reviewService.listarPorJogo(jogoId));
    }

    @PostMapping
    public ResponseEntity<ReviewResponseDTO> criar(@Valid @RequestBody ReviewRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.criar(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        reviewService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}