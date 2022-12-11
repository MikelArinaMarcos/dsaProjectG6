package dsa.proyecto.g6.Models;

public class Tienda {

    private String nombreObjeto;
    private String descripcion;
    private Integer precio;

    public Tienda(){}

    public Tienda(String nombreObjeto, String descripcion, Integer precio) {
        this.nombreObjeto = nombreObjeto;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getNombreObjeto() {
        return nombreObjeto;
    }

    public void setNombreObjeto(String nombreObjeto) {
        this.nombreObjeto = nombreObjeto;
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
