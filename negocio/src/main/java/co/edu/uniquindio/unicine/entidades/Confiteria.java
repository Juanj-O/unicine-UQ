package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Confiteria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String imagen;

    @Column(nullable = false)
    @Positive
    private Float precio;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Teatro teatro;

    @Builder
    public Confiteria(Integer codigo, String nombre, String imagen, Float precio) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
    }
}
