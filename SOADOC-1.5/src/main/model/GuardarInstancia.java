package co.com.foundation.client.rs.gestionar.model;

import java.io.Serializable;

/**
 * Created by Arce on 7/14/2017.
 */
public class GuardarInstancia implements Serializable {

    private static final long serialVersionUID = 1L;

    private String ideAsignacion;
    private String idInstancia;

    public GuardarInstancia() {
    }

    public GuardarInstancia(String idAsignacion, String idInstancia) {
        this.ideAsignacion = idAsignacion;
        this.idInstancia = idInstancia;
    }

    public String getIdeAsignacion() {
        return ideAsignacion;
    }

    public void setIdeAsignacion(String idAsignacion) {
        this.ideAsignacion = idAsignacion;
    }

    public String getIdInstancia() {
        return idInstancia;
    }

    public void setIdInstancia(String idInstancia) {
        this.idInstancia = idInstancia;
    }

    @Override
    public String toString() {
        return "GuardarInstancia{" +
                "idAsignacion='" + ideAsignacion + '\'' +
                ", idInstancia='" + idInstancia + '\'' +
                '}';
    }
}
