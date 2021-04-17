package group7.inventario.inventario.Venta;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class Venta {
    @Id
    private Long ID;
    private Date fecha_emisión;
    private Double igv;
    private Double total;
}
