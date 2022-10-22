package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Compra implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MedioPago medioPago;

    @Column(nullable = false)
    private LocalDateTime fecha;

    @Positive
    @Column(nullable = false)
    private Float valorTotal;

    @ManyToMany
    private List<Confiteria> confiteria;

    @OneToOne
    private Cupon cupon;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Funcion funcion;

    @OneToMany(mappedBy = "compra")
    private List<Entrada> entradas;

    public Compra(MedioPago medioPago, LocalDateTime fecha, Float valorTotal, List<Confiteria> confiteria, Cupon cupon, Cliente cliente, Funcion funcion, List<Entrada> entradas) {
        this.medioPago = medioPago;
        this.fecha = fecha;
        this.valorTotal = valorTotal;
        this.confiteria = confiteria;
        this.cupon = cupon;
        this.cliente = cliente;
        this.funcion = funcion;
        this.entradas = entradas;
    }
}
