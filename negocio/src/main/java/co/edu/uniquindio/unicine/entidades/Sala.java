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
public class Sala implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private String nombre;

    @ManyToOne
    @JoinColumn(nullable = false)
    private DistribucionSillas distribucionSillas;

    @OneToMany(mappedBy = "sala")
    private List<Funcion> funciones;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Teatro teatro;

    public Sala(String nombre, DistribucionSillas distribucionSillas, Teatro teatro) {
        this.nombre = nombre;
        this.distribucionSillas = distribucionSillas;
        this.teatro = teatro;
    }
}
