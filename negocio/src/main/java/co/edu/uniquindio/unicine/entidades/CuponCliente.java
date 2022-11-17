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
public class CuponCliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @JoinColumn(nullable = false)
    private Boolean estado;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cupon cupon;

    @ToString.Exclude
    @OneToOne
    private Compra compra;

    public CuponCliente(Boolean estado, Cliente cliente, Cupon cupon) {
        this.estado = estado;
        this.cliente = cliente;
        this.cupon = cupon;
    }
}
