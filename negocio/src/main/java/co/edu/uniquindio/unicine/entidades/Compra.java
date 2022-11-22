package co.edu.uniquindio.unicine.entidades;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fecha;

    @Positive
    @Column(nullable = false)
    private Float valorTotal;

    //relaciones

    @OneToOne(mappedBy = "compra")
    private CuponCliente cuponCliente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Funcion funcion;
    @JsonIgnore
    @OneToMany(mappedBy = "compra")
    private List<Entrada> entradas;

    @JsonIgnore
    @OneToMany(mappedBy = "compra")
    private List<ConfiteriaCompra> confiteriaCompras;

    @ManyToOne
    @ToString.Exclude
    private Horario horario;


    public Compra(MedioPago medioPago, LocalDateTime fecha, Float valorTotal, CuponCliente cuponCliente, Cliente cliente, Funcion funcion, Horario horario) {
        this.medioPago = medioPago;
        this.fecha = fecha;
        this.valorTotal = valorTotal;
        this.cuponCliente = cuponCliente;
        this.cliente = cliente;
        this.funcion = funcion;
        this.horario = horario;
    }
}
