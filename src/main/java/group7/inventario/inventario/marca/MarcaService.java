package group7.inventario.inventario.marca;



import group7.inventario.inventario.producto.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MarcaService {
    private final MarcaRepository marcaRepository;

    public MarcaService(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }
    public List<Marca> getMarca(){ return marcaRepository.findAll(); }


    public Marca addNewMarca(Marca marca) {
        Optional<Marca> marcaOptional = marcaRepository
                .findMarcaExists(marca.getNombre());
        if (marcaOptional.isPresent()){
            //Tener en cuenta el errorException
            try {
                throw new UserNotFoundException("marca ya existente");
            } catch (UserNotFoundException e) {
                e.printStackTrace();
            }
        }

        System.out.println(marca);
        return marcaRepository.save(marca);
    }
    public List<Marca>getProductoByMarca(Marca id){
        return marcaRepository.findProductoByMarcaExists(id);

    }
}
