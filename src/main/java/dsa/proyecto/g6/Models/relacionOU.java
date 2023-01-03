package dsa.proyecto.g6.Models;

public class relacionOU {
    private Integer idObjeto;
    private Integer idUsuario;

    public relacionOU(){}

    public relacionOU(Integer idObjeto, Integer idUsuario) {
        this.idObjeto = idObjeto;
        this.idUsuario = idUsuario;
    }

    public Integer getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(Integer idObjeto) {
        this.idObjeto = idObjeto;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
}
