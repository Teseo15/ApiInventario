package group7.inventario.inventario.producto;

import group7.inventario.inventario.marca.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {

    @Query("SELECT p FROM Producto p WHERE p.marca.id=?1")
    ArrayList<Producto> findProductoByMarcaExists(long id);

    @Query("SELECT p FROM Producto p WHERE p.nombre=?1")
    Optional<Producto> findEmployeeByProductoExists(String nombre);
    @Query("SELECT p FROM Producto p WHERE p.id=?1")
    Optional<Producto> findById(long id);
    void deleteProductoById(long id);

}
