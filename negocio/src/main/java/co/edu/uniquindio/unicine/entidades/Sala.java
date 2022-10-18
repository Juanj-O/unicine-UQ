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
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private String nombre;

    @OneToMany(mappedBy = "sala")
    private List<SillaSala> sillaSalas;

    @OneToMany(mappedBy = "sala")
    private List<Funcion> funciones;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Teatro teatro;

    @Builder
    public Sala(String nombre, List<SillaSala> sillaSalas, List<Funcion> funciones, Teatro teatro) {
        this.nombre = nombre;
        this.sillaSalas = sillaSalas;
        this.funciones = funciones;
        this.teatro = teatro;
    }
}
