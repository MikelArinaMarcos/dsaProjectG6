package dsa.proyecto.g6.Models;

import dsa.proyecto.g6.Util.IDs;

public class Objeto {

    private String nombre;
    private String descripcion;
    private Integer precio;

    private Integer idObjeto;

    public Objeto(){}
    public Objeto(String nombre, String descripcion, int precio) {
        this.idObjeto = IDs.generarId();
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Integer getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(Integer idObjeto) {
        this.idObjeto = idObjeto;
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
}
