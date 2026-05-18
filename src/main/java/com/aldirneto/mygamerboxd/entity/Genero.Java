package com.aldirneto.mygamerboxd.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombox.*;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "generos")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@ToString(exclude = "jogos")
@EqualsAndHashCode(of = "id")
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, unique = true, length = 50)
    private String nome;
    // Relacionamento
    @ManyToMany(mappedBy = "generos")
    @JsonIgnore
    private Set<Jogo> jogos = new HashSet<>();
}