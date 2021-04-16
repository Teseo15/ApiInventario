package group7.inventario.producto;

import javax.persistence.Id;

public class Producto {
    @Id
    private Long id;
    private String descripcion;
    private Double precio_compra;
    private Double precio_venta;

}
