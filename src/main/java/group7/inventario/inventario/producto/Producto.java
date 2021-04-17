package group7.inventario.inventario.producto;

import group7.inventario.inventario.categoria.Categoria;

import javax.persistence.*;

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

    @Column(
            nullable = false
            // unique = true
            )
    private Double precio_compra;

    @Column(nullable = false)
    private Double precio_venta;

    @Column(nullable = true)
    private Integer cantidad;

    @ManyToOne
    /*@JoinColumn(
            //  name = "student_id",
            nullable = false,

            // referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "producto_categoria_fk"
            )
    )*/
    private Categoria categoria;

    public Producto() {
    }

    public Producto(String descripcion, Double precio_compra, Double precio_venta, Integer cantidad, Categoria categoria) {
        this.descripcion = descripcion;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public Producto(Long id, String descripcion, Double precio_compra, Double precio_venta, Integer cantidad, Categoria categoria) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.cantidad = cantidad;
        this.categoria = categoria;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Producto(Long id, String descripcion, Double precio_compra, Double precio_venta, Categoria categoria) {
        this.id = id;
        this.descripcion = descripcion;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto(Long id, String nombre, String descripcion, Double precio_compra, Double precio_venta, Integer cantidad, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.cantidad = cantidad;
        this.categoria = categoria;
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

    public Double getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(Double precio_compra) {
        this.precio_compra = precio_compra;
    }

    public Double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(Double precio_venta) {
        this.precio_venta = precio_venta;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                ", precio_compra=" + precio_compra +
                ", precio_venta=" + precio_venta +
                ", categoria=" + categoria +
                '}';
    }
}
