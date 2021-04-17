package group7.inventario.inventario.producto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/producto")
public class ProductoController {
    private final ProductoService productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }
    @GetMapping(path = "/all")
    public ResponseEntity<List<Producto>> mostrar(){
        List<Producto> productos = productoService.getProducto();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
    @PostMapping(path = "/add")
    public ResponseEntity<Producto> registerNewProducto(@RequestBody Producto producto){
        Producto newproducto = productoService.addNewProducto(producto);
        return new  ResponseEntity<>(newproducto,HttpStatus.OK);
    }
}
