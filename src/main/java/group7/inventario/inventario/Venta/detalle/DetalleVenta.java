package group7.inventario.inventario.Venta.detalle;

import com.sun.istack.NotNull;
import group7.inventario.inventario.Venta.Venta;
import group7.inventario.inventario.producto.Producto;

import javax.persistence.*;

@Entity(name = "DetalleVenta")
@Table(name = "detalleventa")
public class DetalleVenta {
    @Id
    @SequenceGenerator(
            name = "detalle_sequence",
            sequenceName = "detalle_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "detalle_sequence"
    )
    private Long id;
    @ManyToOne
    private Producto producto;
    @ManyToOne
    private Venta venta;
    private int cantidad;
    @Column(
            nullable = true
            // unique = true
    )
    private Double aporte;

    public DetalleVenta() {
    }

    public DetalleVenta(Long id, Producto producto, Venta venta, int cantidad, Double aporte) {
        this.id = id;
        this.producto = producto;
        this.venta = venta;
        this.cantidad = cantidad;
        this.aporte = aporte;
    }

    public DetalleVenta(Producto producto, Venta venta, int cantidad, Double aporte) {
        this.producto = producto;
        this.venta = venta;
        this.cantidad = cantidad;
        this.aporte = aporte;
    }

    public DetalleVenta(Double aporte) {
        this.aporte = aporte;
    }


    @Override
    public String toString() {
        return "DetalleVenta{" +
                "id=" + id +
                ", producto=" + producto +
                ", venta=" + venta +
                ", cantidad=" + cantidad +
                ", aporte=" + aporte +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Double getAporte() {
        return aporte;
    }

    public void setAporte(Double aporte) {
        this.aporte = aporte;
    }
}
