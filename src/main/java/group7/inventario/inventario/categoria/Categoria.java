package group7.inventario.inventario.categoria;

import javax.persistence.*;
@Entity( name = "Categoria")
@Table(name = "categoria")
public class Categoria {
    @Id
    @SequenceGenerator(
            name = "categoria_sequence",
            sequenceName = "categoria_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "categoria_sequence"
    )
    private Long id;
    private String nombre;

    public Categoria(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }


    /*
        @OneToMany
              (
                mappedBy = "categoria",
                orphanRemoval = true,
                cascade = {CascadeType.PERSIST, CascadeType.REMOVE},
                fetch = FetchType.LAZY
        )
    private List<Producto> producto = new ArrayList<>();*/

    public Categoria() {

    }

    public Categoria(String nombre) {
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
        return "Categoria{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
