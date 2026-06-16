package com.aldirneto.mygamerboxd.controller;
import com.aldirneto.mygamerboxd.dto.PlataformaRequestDTO;
import com.aldirneto.mygamerboxd.dto.PlataformaResponseDTO;
import com.aldirneto.mygamerboxd.service.PlataformaService;
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
@RequestMapping("/api/plataformas")
@Tag(name = "Plataformas", description = "Gerenciamento de plataformas de jogos")
public class PlataformaController {
    @Autowired
    private PlataformaService plataformaService;
    @Operation(summary = "Lista todas as plataformas")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    @GetMapping
    public ResponseEntity<List<PlataformaResponseDTO>> listarTodas() {
        return ResponseEntity.ok(plataformaService.listarTodas());
    }
    @Operation(summary = "Busca uma plataforma pelo ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Plataforma encontrada"),
        @ApiResponse(responseCode = "404", description = "Plataforma não encontrada")
    })
    @GetMapping("/{id}")
    public ResponseEntity<PlataformaResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(plataformaService.buscarPorId(id));
    }
    @Operation(summary = "Cria uma nova plataforma")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Plataforma criada com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados da requisição inválidos")
    })
    @PostMapping
    public ResponseEntity<PlataformaResponseDTO> criar(@Valid @RequestBody PlataformaRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(plataformaService.criar(dto));
    }
    @Operation(summary = "Atualiza uma plataforma existente")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Plataforma atualizada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Plataforma não encontrada"),
        @ApiResponse(responseCode = "400", description = "Dados da requisição inválidos")
    })
    @PutMapping("/{id}")
    public ResponseEntity<PlataformaResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody PlataformaRequestDTO dto) {
        return ResponseEntity.ok(plataformaService.atualizar(id, dto));
    }
    @Operation(summary = "Deleta uma plataforma pelo ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Plataforma deletada com sucesso"),
        @ApiResponse(responseCode = "404", description = "Plataforma não encontrada")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        plataformaService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}