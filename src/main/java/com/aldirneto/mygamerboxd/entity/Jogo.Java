package com.aldirneto.mygamerboxd.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "jogos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString(exclude = {"generos", "plataformas", "avaliacoes"})
@EqualsAndHashCode(of = "id")
public class Jogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 150)
    private String titulo;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    @Column(precision = 3, escale = 2)
    private BigDecimal notaMedia;
    // Relacionamentos
    //Gênero
    @ManyToMany
    @JoinTable(name = "tb_jogo_genero",
            joinColumns = @JoinColumn(name = "jogo_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id")
    )
    private Set<Genero> generos = new HashSet<>();
    //Plataforma
    @ManyToMany
    @JoinTable(name = "tb_jogo_plataforma",
            joinColumns = @JoinColumn(name = "jogo_id"),
            inverseJoinColumns = @JoinColumn(name = "plataforma_id")
    )
    private Set<Plataforma> plataformas = new HashSet<>();
    //Avaliação
    @OneToMany(mappedBy = "jogo", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Avaliacao> avaliacoes = new ArrayList<>();
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dataCriacao;
    @UpdateTimestamp
    private LocalDateTime dataAtualizacao;
}