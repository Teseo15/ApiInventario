package group7.inventario.inventario.cliente;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class Cliente {
    @Id
    private Long ID;
    private String nombre;
    private String email;
}
