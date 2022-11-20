package co.edu.uniquindio.unicine.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @JsonIgnore
    @ManyToMany(mappedBy = "peliculas")
    private List<Genero> generos;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "pelicula")
    private List<Funcion> funciones;

    public Pelicula(String nombre, String imagen, String trailer, String sipnosis, String reparto, Boolean estado) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.trailer = trailer;
        this.sipnosis = sipnosis;
        this.reparto = reparto;
        this.estado = estado;
    }
}
