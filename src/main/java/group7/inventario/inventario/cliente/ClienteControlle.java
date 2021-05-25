package group7.inventario.inventario.cliente;

import group7.inventario.inventario.categoria.Categoria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteControlle {

    private final ClienteService clienteService;

    public ClienteControlle(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Cliente>> mostrar(){
        List<Cliente> categorias = clienteService.getCliente();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }
    @PostMapping(path = "/add")
    public ResponseEntity<Cliente> registerNewCliente(@RequestBody Cliente cliente){
        Cliente newcategoria = clienteService.addNewCliente(cliente);
        return new  ResponseEntity<>(newcategoria,HttpStatus.OK);
    }
}
