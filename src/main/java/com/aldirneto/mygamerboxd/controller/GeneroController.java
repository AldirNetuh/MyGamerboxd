package com.aldirneto.mygamerboxd.controller;
import com.aldirneto.mygamerboxd.dto.GeneroRequestDTO;
import com.aldirneto.mygamerboxd.dto.GeneroResponseDTO;
import com.aldirneto.mygamerboxd.service.GeneroService;
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
@RequestMapping("/api/generos")
@Tag(name = "Gêneros", description = "Gerenciamento de categorias de jogos")
public class GeneroController {
    @Autowired
    private GeneroService generoService;
    @Operation(summary = "Lista todos os gêneros")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    @GetMapping
    public ResponseEntity<List<GeneroResponseDTO>> listarTodos() {
        return ResponseEntity.ok(generoService.listarTodos());
    }
    @Operation(summary = "Busca um gênero pelo ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Gênero encontrado"),
        @ApiResponse(responseCode = "404", description = "Gênero não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<GeneroResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(generoService.buscarPorId(id));
    }
    @Operation(summary = "Cria um novo gênero")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Gênero criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados da requisição inválidos")
    })
    @PostMapping
    public ResponseEntity<GeneroResponseDTO> criar(@Valid @RequestBody GeneroRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(generoService.criar(dto));
    }
    @Operation(summary = "Atualiza um gênero existente")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Gênero atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Gênero não encontrado"),
        @ApiResponse(responseCode = "400", description = "Dados da requisição inválidos")
    })
    @PutMapping("/{id}")
    public ResponseEntity<GeneroResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody GeneroRequestDTO dto) {
        return ResponseEntity.ok(generoService.atualizar(id, dto));
    }
    @Operation(summary = "Deleta um gênero pelo ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Gênero deletado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Gênero não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        generoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}