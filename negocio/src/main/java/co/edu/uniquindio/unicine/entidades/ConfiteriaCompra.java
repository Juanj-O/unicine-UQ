package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ConfiteriaCompra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private Integer unidades;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Confiteria confiteria;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Compra compra;

    public ConfiteriaCompra(Double precio, Integer unidades, Confiteria confiteria, Compra compra) {
        this.precio = precio;
        this.unidades = unidades;
        this.confiteria = confiteria;
        this.compra = compra;
    }
}
