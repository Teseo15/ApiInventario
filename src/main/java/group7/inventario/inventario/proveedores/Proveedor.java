package group7.inventario.inventario.proveedores;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Proveedor")
@Table(name = "proveedor")
public class Proveedor {

    @Id
    private Long id;
    private String ruc;
    private String direccion;
    private String telefono;
    private String correo;
    private String vendedor;

    public Proveedor() {
    }

    public Proveedor(Long id, String ruc, String direccion, String telefono, String correo, String vendedor) {
        this.id = id;
        this.ruc = ruc;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.vendedor = vendedor;
    }

    public Proveedor(String ruc, String direccion, String telefono, String correo, String vendedor) {
        this.ruc = ruc;
        this.direccion = direccion;
        this.telefono = telefono;
        this.correo = correo;
        this.vendedor = vendedor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "id=" + id +
                ", ruc='" + ruc + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", correo='" + correo + '\'' +
                ", vendedor='" + vendedor + '\'' +
                '}';
    }
}
