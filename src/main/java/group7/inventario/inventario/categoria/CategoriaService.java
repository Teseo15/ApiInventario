package group7.inventario.inventario.categoria;

import group7.inventario.inventario.producto.Producto;
import group7.inventario.inventario.producto.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    private  final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }
    public List<Categoria> getCategoria(){ return categoriaRepository.findAll(); }
    public Categoria addNewCategoria(Categoria categoria) {
        System.out.println(categoria);
        return categoriaRepository.save(categoria);
    }
}
