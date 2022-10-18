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
public class Silla implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private String fila;

    @Column(nullable = false)
    private String columna;

    @OneToMany(mappedBy = "silla")
    private List<SillaSala> sillaSalas;

    @Builder
    public Silla(String fila, String columna, List<SillaSala> sillaSalas) {
        this.fila = fila;
        this.columna = columna;
        this.sillaSalas = sillaSalas;
    }
}
