package group7.inventario.inventario.Venta;

import group7.inventario.inventario.Venta.detalle.DetalleVenta;
import group7.inventario.inventario.Venta.detalle.DetalleVentaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/venta")
public class Controlador {

    private final VentaService ventaService;
    private final DetalleVentaService detalleVentaService;

    @Autowired
    public Controlador(VentaService ventaService, DetalleVentaService detalleVentaService) {
        this.ventaService = ventaService;
        this.detalleVentaService = detalleVentaService;
    }
    @GetMapping(path = "/all")
    public ResponseEntity<List<DetalleVenta>> mostrar(){
        List<DetalleVenta> productos = detalleVentaService.getDetalleVenta();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
    @PostMapping(path = "/add")
    public ResponseEntity<Venta> registerNewVenta(@RequestBody Venta venta){

        Venta newventa = ventaService.addNewVenta(venta);
        return new  ResponseEntity<>(newventa,HttpStatus.OK);
    }
    @PostMapping(path = "/detalle/add")
    public ResponseEntity<DetalleVenta> registerNewDetalle(@RequestBody DetalleVenta detalleVenta){

        DetalleVenta newdetalleVenta = detalleVentaService.addNewDetalleVenta(detalleVenta);
        return new  ResponseEntity<>(newdetalleVenta,HttpStatus.OK);
    }
}
