package group7.inventario.inventario.cliente;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "Cliente")
@Table(name = "cliente")
public class Cliente {
    @Id
    @SequenceGenerator(
            name = "cliente_sequence",
            sequenceName = "cliente_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "cliente_sequence"
    )
    private Long ID;
    private String nombre;
    private String email;

    public Cliente() {
    }

    public Cliente(Long ID, String nombre, String email) {
        this.ID = ID;
        this.nombre = nombre;
        this.email = email;
    }

    public Cliente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "ID=" + ID +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
