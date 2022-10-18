package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SillaSala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    @Positive
    private Float precio;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Sala sala;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Silla silla;

    //@OneToMany(mappedBy = "silla_sala")
    //private List<Entrada> entradas;
    @Builder
    public SillaSala(Float precio, Sala sala, Silla silla /*List<Entrada> entradas*/) {
        this.precio = precio;
        this.sala = sala;
        this.silla = silla;
        //this.entradas = entradas;
    }
}
