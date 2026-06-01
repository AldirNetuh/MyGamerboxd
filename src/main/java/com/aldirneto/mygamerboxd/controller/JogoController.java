package com.aldirneto.mygamerboxd.controller;

import com.aldirneto.mygamerboxd.dto.JogoRequestDTO;
import com.aldirneto.mygamerboxd.dto.JogoResponseDTO;
import com.aldirneto.mygamerboxd.service.JogoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jogos")
public class JogoController {

    @Autowired
    private JogoService jogoService;

    @GetMapping
    public ResponseEntity<List<JogoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(jogoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<JogoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(jogoService.buscarPorId(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<JogoResponseDTO>> buscarPorTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(jogoService.buscarPorTitulo(titulo));
    }

    @PostMapping
    public ResponseEntity<JogoResponseDTO> criar(@Valid @RequestBody JogoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jogoService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JogoResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody JogoRequestDTO dto) {
        return ResponseEntity.ok(jogoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        jogoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}