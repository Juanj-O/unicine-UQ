package co.edu.uniquindio.unicine.entidades;

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
public class Funcion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private Float precio;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Sala sala;

    @ToString.Exclude
    @OneToMany(mappedBy = "funcion")
    private List<Horario> horario;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Pelicula pelicula;

    public Funcion(Float precio, Sala sala, Pelicula pelicula) {
        this.precio = precio;
        this.sala = sala;
        this.pelicula = pelicula;
    }
}
