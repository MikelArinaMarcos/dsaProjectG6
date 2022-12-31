package dsa.proyecto.g6.Models;

public class Objeto {

    private Integer idObjeto;
    private String nombre;
    private String descripcion;
    private Integer precio;

    public Objeto(){}
    public Objeto(Integer idObjeto, String nombre, String descripcion, int precio) {
        this.idObjeto = idObjeto;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Integer getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(Integer idObjeto) {
        this.idObjeto = idObjeto;
    }
}
