package group7.inventario.inventario.producto;

import group7.inventario.inventario.categoria.Categoria;
import group7.inventario.inventario.marca.Marca;

import javax.persistence.*;
import java.sql.Date;

@Entity(name = "Producto")
@Table(name = "producto")
public class Producto {
    @Id
    @SequenceGenerator(
            name = "producto_sequence",
            sequenceName = "producto_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "producto_sequence"
    )
    private Long id;
    private String nombre;
    private String descripcion;


    private Date vencimiento;

    @Column(
            nullable = false
            // unique = true
            )
    private Double precio_costo_unitario;

    @Column(nullable = false)
    private Double precio_venta_unitario;

    @Column(nullable = true)
    private int cantidad;
    @ManyToOne
    private Categoria categoria;
    @ManyToOne
    private Marca marca;
    private String image;

    public Producto() {
    }

    public Producto(Long id, String nombre, String descripcion, Date vencimiento, Double precio_costo_unitario, Double precio_venta_unitario, int cantidad, Categoria categoria, Marca marca, String image) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.vencimiento = vencimiento;
        this.precio_costo_unitario = precio_costo_unitario;
        this.precio_venta_unitario = precio_venta_unitario;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.marca = marca;
        this.image = image;
    }

    public Producto(String nombre, String descripcion, Date vencimiento, Double precio_costo_unitario, Double precio_venta_unitario, int cantidad, Categoria categoria, Marca marca, String image) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.vencimiento = vencimiento;
        this.precio_costo_unitario = precio_costo_unitario;
        this.precio_venta_unitario = precio_venta_unitario;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.marca = marca;
        this.image = image;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", vencimiento=" + vencimiento +
                ", precio_costo_unitario=" + precio_costo_unitario +
                ", precio_venta_unitario=" + precio_venta_unitario +
                ", cantidad=" + cantidad +
                ", categoria=" + categoria +
                ", marca=" + marca +
                ", image='" + image + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    public Double getPrecio_costo_unitario() {
        return precio_costo_unitario;
    }

    public void setPrecio_costo_unitario(Double precio_costo_unitario) {
        this.precio_costo_unitario = precio_costo_unitario;
    }

    public Double getPrecio_venta_unitario() {
        return precio_venta_unitario;
    }

    public void setPrecio_venta_unitario(Double precio_venta_unitario) {
        this.precio_venta_unitario = precio_venta_unitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
