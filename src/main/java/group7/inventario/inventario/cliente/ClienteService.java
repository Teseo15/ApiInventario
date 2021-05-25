package group7.inventario.inventario.cliente;

import group7.inventario.inventario.categoria.Categoria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    public List<Cliente> getCliente(){ return clienteRepository.findAll(); }
    public Cliente addNewCliente(Cliente cliente) {

        return clienteRepository.save(cliente);
    }
}
