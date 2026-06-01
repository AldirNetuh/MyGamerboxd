package com.aldirneto.mygamerboxd.controller;

import com.aldirneto.mygamerboxd.dto.PlataformaRequestDTO;
import com.aldirneto.mygamerboxd.dto.PlataformaResponseDTO;
import com.aldirneto.mygamerboxd.service.PlataformaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/plataformas")
public class PlataformaController {

    @Autowired
    private PlataformaService plataformaService;

    @GetMapping
    public ResponseEntity<List<PlataformaResponseDTO>> listarTodas() {
        return ResponseEntity.ok(plataformaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlataformaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(plataformaService.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<PlataformaResponseDTO> criar(@Valid @RequestBody PlataformaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(plataformaService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlataformaResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody PlataformaRequestDTO dto) {
        return ResponseEntity.ok(plataformaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        plataformaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}