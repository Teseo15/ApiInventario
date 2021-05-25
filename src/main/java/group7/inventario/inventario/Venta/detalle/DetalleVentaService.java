package group7.inventario.inventario.Venta.detalle;

import group7.inventario.inventario.producto.Producto;
import group7.inventario.inventario.producto.ProductoRepository;
import group7.inventario.inventario.producto.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleVentaService {
    private final DetalleVentaRepository detalleVentaRepository;
    private final ProductoRepository productoRepository;
    private final ProductoService productoService;

    @Autowired
    public DetalleVentaService(DetalleVentaRepository detalleVentaRepository, ProductoRepository productoRepository, ProductoService productoService) {
        this.detalleVentaRepository = detalleVentaRepository;
        this.productoRepository = productoRepository;
        this.productoService = productoService;
    }


    public List<DetalleVenta> getDetalleVenta(){ return detalleVentaRepository.findAll(); }

    public DetalleVenta addNewDetalleVenta(DetalleVenta detalleVenta) {

        long id =detalleVenta.getProducto().getId();
        Optional<Producto> producto=productoService.buscarProducto(id);
        int cantidad=detalleVenta.getCantidad();
        Double precio =producto.get().getPrecio_venta_unitario();
        Double aporte=cantidad*precio;
        detalleVenta.setAporte(aporte);

        System.out.println("ID "+id);
        System.out.println("CANTIDAD "+cantidad);
        System.out.println("PRECIO"+precio);
        System.out.println("APORTE"+aporte);

        return detalleVentaRepository.save(detalleVenta);
    }
}
