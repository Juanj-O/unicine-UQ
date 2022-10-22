package co.edu.uniquindio.unicine.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DistribucionSillas implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private String esquema;

    @Column(nullable = false)
    private Integer total_sillas;

    @Column(nullable = false)
    private Integer filas;

    @Column(nullable = false)
    private Integer columnas;

    @OneToMany(mappedBy = "distribucionSillas")
    private List<Sala> salas;

    public DistribucionSillas(String esquema, Integer total_sillas, Integer filas, Integer columnas, List<Sala> salas) {
        this.esquema = esquema;
        this.total_sillas = total_sillas;
        this.filas = filas;
        this.columnas = columnas;
        this.salas = salas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        DistribucionSillas that = (DistribucionSillas) o;
        return codigo != null && Objects.equals(codigo, that.codigo);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
