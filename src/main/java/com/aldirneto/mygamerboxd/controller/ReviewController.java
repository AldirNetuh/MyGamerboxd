package com.aldirneto.mygamerboxd.controller;
import com.aldirneto.mygamerboxd.dto.ReviewRequestDTO;
import com.aldirneto.mygamerboxd.dto.ReviewResponseDTO;
import com.aldirneto.mygamerboxd.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@Tag(name = "Reviews", description = "Gerenciamento de avaliações dos jogos")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    @Operation(summary = "Lista todas as avaliações")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    @GetMapping
    public ResponseEntity<List<ReviewResponseDTO>> listarTodas() {
        return ResponseEntity.ok(reviewService.listarTodas());
    }
    @Operation(summary = "Lista as avaliações de um jogo específico")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    @GetMapping("/jogo/{jogoId}")
    public ResponseEntity<List<ReviewResponseDTO>> listarPorJogo(@PathVariable Long jogoId) {
        return ResponseEntity.ok(reviewService.listarPorJogo(jogoId));
    }
    @Operation(summary = "Cria uma nova avaliação")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Avaliação criada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados da requisição inválidos"),
        @ApiResponse(responseCode = "404", description = "Jogo ou Usuário não encontrado")
    })
    @PostMapping
    public ResponseEntity<ReviewResponseDTO> criar(@Valid @RequestBody ReviewRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(reviewService.criar(dto));
    }
    @Operation(summary = "Deleta uma avaliação pelo ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Avaliação deletada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Avaliação não encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        reviewService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}