package com.aldirneto.mygamerboxd.controller;
import com.aldirneto.mygamerboxd.dto.JogoRequestDTO;
import com.aldirneto.mygamerboxd.dto.JogoResponseDTO;
import com.aldirneto.mygamerboxd.service.JogoService;
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
@RequestMapping("/api/jogos")
@Tag(name = "Jogos", description = "Catálogo e gerenciamento de jogos")
public class JogoController {

    @Autowired
    private JogoService jogoService;
    @Operation(summary = "Lista todos os jogos")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    })
    @GetMapping
    public ResponseEntity<List<JogoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(jogoService.listarTodos());
    }
    @Operation(summary = "Busca um jogo pelo ID")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Jogo encontrado"),
        @ApiResponse(responseCode = "404", description = "Jogo não encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<JogoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(jogoService.buscarPorId(id));
    }
    @Operation(summary = "Busca jogos contendo o título especificado")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso")
    })
    @GetMapping("/buscar")
    public ResponseEntity<List<JogoResponseDTO>> buscarPorTitulo(@RequestParam String titulo) {
        return ResponseEntity.ok(jogoService.buscarPorTitulo(titulo));
    }
    @Operation(summary = "Cria um novo jogo")
    @ApiResponses({
        @ApiResponse(responseCode = "201", description = "Jogo criado com sucesso"),
        @ApiResponse(responseCode = "400", description = "Dados da requisição inválidos")
    })
    @PostMapping
    public ResponseEntity<JogoResponseDTO> criar(@Valid @RequestBody JogoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(jogoService.criar(dto));
    }
    @Operation(summary = "Atualiza um jogo existente")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Jogo atualizado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Jogo não encontrado"),
        @ApiResponse(responseCode = "400", description = "Dados da requisição inválidos")
    })
    @PutMapping("/{id}")
    public ResponseEntity<JogoResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody JogoRequestDTO dto) {
        return ResponseEntity.ok(jogoService.atualizar(id, dto));
    }
    @Operation(summary = "Deleta um jogo pelo ID")
    @ApiResponses({
        @ApiResponse(responseCode = "204", description = "Jogo deletado com sucesso"),
        @ApiResponse(responseCode = "404", description = "Jogo não encontrado")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        jogoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}