package group7.inventario.inventario.Venta;

import group7.inventario.inventario.cliente.Cliente;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Venta")
@Table(name = "venta")
public class Venta {
    @Id
    @SequenceGenerator(
            name = "venta_sequence",
            sequenceName = "venta_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "venta_sequence"
    )
    private Long id;
    private Date fechaEmision;
    @ManyToOne
    private Cliente cliente;

    public Venta() {
    }

    public Venta(Long id,Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    public Venta(Long id, Date fechaEmision, Cliente cliente) {
        this.id = id;
        this.fechaEmision = fechaEmision;
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "Venta{" +
                "id=" + id +
                ", fechaEmision=" + fechaEmision +
                ", cliente=" + cliente +
                '}';
    }
}
