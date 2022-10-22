package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
public class Pelicula implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String imagen;

    @Column(nullable = false)
    private String trailer;

    @Column(nullable = false, length = 150)
    private String sipnosis;

    @Column(nullable = false)
    private String reparto;

    @Column(nullable = false)
    private Boolean estado;

    @ManyToMany(mappedBy = "peliculas")
    private List<Genero> generos;
}
