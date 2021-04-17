package group7.inventario.inventario.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    //getProducto obtiene todos los datos de la tabla producto a travez de repositorio y la función findAll() de la interface.
    public List<Producto> getProducto(){ return productoRepository.findAll(); }

    //Agregar un nuevo Producto
    public Producto addNewProducto(Producto producto) {
        Optional<Producto> productoOptional = productoRepository
                .findEmployeeByProductoExists(producto.getNombre());
        if (productoOptional.isPresent()){
            //Tener en cuenta el errorException
            try {
                throw new UserNotFoundException("producto ya existente");
            } catch (UserNotFoundException e) {
                e.printStackTrace();
            }
        }

        System.out.println(producto);
        return productoRepository.save(producto);
    }

}
