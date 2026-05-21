package com.aldirneto.mygamerboxd.controller;
import com.aldirneto.mygamerboxd.dto.GeneroRequestDTO;
import com.aldirneto.mygamerboxd.dto.GeneroResponseDTO;
import com.aldirneto.mygamerboxd.service.GeneroService;
import jakata.vaidation.valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequesrMapping("/api/generos")
public class GeneroController {
    @Autowired
    private GeneroService generoService;

    @GetMapping
    public ResponseEntity<GeneroResponseDTO>> listarTodos(){
        return ResponseEntity.ok(generoService.listarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<GeneroResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(generoService.buscarPorId(id));
    }
}