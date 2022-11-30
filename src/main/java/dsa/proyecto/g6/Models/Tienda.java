package dsa.proyecto.g6.Models;

public class Tienda {

    private String NombreObjeto;
    private String descripcion;
    private Integer precio;


    public Tienda(String nombreObjeto, String descripcion, Integer precio) {
        NombreObjeto = nombreObjeto;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getNombreObjeto() {
        return NombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        NombreObjeto = nombreObjeto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }
}
