package group7.inventario.inventario.categoria;

import group7.inventario.inventario.producto.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/categoria")
public class CategoriaController {
    private final CategoriaService categoriaService;
    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }
    @GetMapping(path = "/all")
    public ResponseEntity<List<Categoria>> mostrar(){
        List<Categoria> categorias = categoriaService.getCategoria();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }
    @PostMapping(path = "/add")
    public ResponseEntity<Categoria> registerNewCategoria(@RequestBody Categoria categoria){
        Categoria newcategoria = categoriaService.addNewCategoria(categoria);
        return new  ResponseEntity<>(newcategoria,HttpStatus.OK);
    }

}
