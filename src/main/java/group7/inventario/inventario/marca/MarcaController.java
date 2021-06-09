package group7.inventario.inventario.marca;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(path ="/marca")
public class MarcaController {

    private final MarcaService marcaService;

    public MarcaController(MarcaService marcaService) {
        this.marcaService = marcaService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Marca>> mostrar(){
        List<Marca> marcas = marcaService.getMarca();
        return new ResponseEntity<>(marcas, HttpStatus.OK);
    }
    @PostMapping(path = "/add")
    public ResponseEntity<Marca> registerNewMarca(@RequestBody Marca marca){
        Marca newMarca = marcaService.addNewMarca(marca);
        return new  ResponseEntity<>(newMarca,HttpStatus.CREATED);
    }

}
