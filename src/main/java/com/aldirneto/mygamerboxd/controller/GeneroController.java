package com.aldirneto.mygamerboxd.controller;

import com.aldirneto.mygamerboxd.dto.GeneroRequestDTO;
import com.aldirneto.mygamerboxd.dto.GeneroResponseDTO;
import com.aldirneto.mygamerboxd.service.GeneroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public ResponseEntity<List<GeneroResponseDTO>> listarTodos() {
        return ResponseEntity.ok(generoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<GeneroResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(generoService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<GeneroResponseDTO> criar(@Valid @RequestBody GeneroRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(generoService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<GeneroResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody GeneroRequestDTO dto) {
        return ResponseEntity.ok(generoService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        generoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}