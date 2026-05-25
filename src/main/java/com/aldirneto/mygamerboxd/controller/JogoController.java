package com.aldirneto.mygamerboxd.controller;
import com.aldirneto.mygamerboxd.dto.JogoRequestDTO;
import com.aldirneto.mygamerboxd.dto.JogoResponseDTO;
import com.aldirneto.mygamerboxd.servide.JogoService;
import jakarta.validation.Valid;
import org.springFramework.beans.factory.annotation.Autowired;
import org.springFramework.http.HttpStatus;
import org.springFramework.http.ResponseEntity;
import org.springFramework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/jogos")
public class JogoController{
    @Autowired
        private JogoService jogaService;
    @GetMapping
    public ResponseEntity<List<JogoResponseDTO> listarTodos() {
        return ResponseEntity.ok(jogaService.listarTodos());
    }
    @GetMapping("/{id}")
    public ResponseEntity<JogoResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(jogaService.buscarPorId(id));
    }

    @GetMapping("/busca")
    public ResponseEntity<List<JogoResponseDTO>> buscarPorTitulo(@RequestParam String q){
        return ResponseEntity.ok(jogaService.buscarPorTitulo(q));
    }

    @PostMapping
    public ResponseEntity<JogoResponseDTO> criar(@Valid @RequestBody JogoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jogaService.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<JogoResponseDTO> atualizar (@PathVariable Long id, @Valid @RequestBody JogoResponseDTO dto){
        return ResponseEntity.ok(jogaService.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PatchVariable Long id) {
        jogaService.deletar(id)
        return ResponseEntity.noContent().build();
    }
}