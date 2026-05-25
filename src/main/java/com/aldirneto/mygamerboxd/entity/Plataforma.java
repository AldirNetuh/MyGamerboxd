package com.aldirneto.mygamerboxd.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "plataformas")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString(exclude = "jogos")
@EqualsAndHashCode(of = "id")
public class plataforma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 50)
    private String nome;
    // Relacionamento
    @ManyToMany(mappedBy = "plataformas")
    @JsonIgnore
    private Set<Jogo> jogos = new HashSet<>();
}