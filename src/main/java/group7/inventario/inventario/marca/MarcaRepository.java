package group7.inventario.inventario.marca;



import group7.inventario.inventario.producto.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface MarcaRepository extends JpaRepository<Marca,Long> {
    @Query("SELECT p.id,p.nombre,p.categoria,p.cantidad ,p.marca.nombre FROM Producto p WHERE p.marca.id=?1")
    ArrayList<Marca> findProductoByMarcaExists(Marca id);

    @Query("SELECT p FROM Marca p WHERE p.nombre=?1")
    Optional<Marca> findMarcaExists(String nombre);
}
