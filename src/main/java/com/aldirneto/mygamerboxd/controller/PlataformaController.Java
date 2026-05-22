package com.aldirneto.mygamerboxd.controller;
import com.aldirneto.mygamerboxd.dto.PlataformaRequestDTO;
import com.aldirneto.mygamerboxd.dto.PlataformaResponseDTO;
import com.aldirneto.mygamerboxd.service.PLataformaService;
import jakarta.validation.Valid;
import org.springFramework.beans.factory.annotation.Autowired;
import org.springFramework.http.HttpStatus;
import org.springFramework.http.ResponseEntity;
import org.springFramework.web.binc.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/platformas")
public class PLataformaController {
    @Autowired
    private class PLataformaService plataformaService;
    @GetMapping
    public ResponseEntity<list<PlataformaRequestDTO>> listarTodas(){
        return ResponseEntity.ok(plataformaService.listarTodas());
    }
    @GetMapping("/{id}")
    public ResponseEntity<PlataformaResponseDTO> buscarPorId(@PathVariable Long id){
        return ResponseEntity.ok(plataformaService.buscarPorId(id))
    }
    @PostMapping
    public ResponseEntity<PlataformaResponseDTO> criar(@Valid @RequestBody PlataformaRequestDTO dto){
        return REsponseEsntity.status(HttpStatus.CREATED).body(plataformaService.criar(dto));
    }
    @PutMapping("/{id}")
    public ResponseEntity<PlataformaResponseDTO> atualizar(@PathVariable Lond id, @Valid @RequestBody PlataformaRequestDTO dto){
        return ResponseEntity.ok(plataformaService.atualizar(id, dto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        plataformaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}