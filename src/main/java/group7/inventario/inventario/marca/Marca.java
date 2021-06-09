package group7.inventario.inventario.marca;

import javax.persistence.*;

@Entity( name = "Marca")
@Table(name = "marca")
public class Marca {
    @Id
    @SequenceGenerator(
            name = "marca_sequence",
            sequenceName = "marca_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "marca_sequence"
    )
    private Long id;
    private String nombre;

    public Marca() {
    }

    public Marca(Long id) {
        this.id = id;
    }

    public Marca(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Marca(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Marca{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
