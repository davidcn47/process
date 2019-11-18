package co.com.foundation.client.rs.gestionar.model;

import java.io.Serializable;

/**
 * Created by Arce on 7/14/2017.
 */
public class Agente implements Serializable {

    private static final long serialVersionUID = -5692073949092232892L;
    private String ideAgente;
    private String codEstado;

    public Agente() {
    }

    public String getIdeAgente() {
        return ideAgente;
    }

    public void setIdeAgente(String ideAgente) {
        this.ideAgente = ideAgente;
    }

    public String getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(String codEstado) {
        this.codEstado = codEstado;
    }

    public Agente(String ideAgente, String codEstado) {
        this.ideAgente = ideAgente;
        this.codEstado = codEstado;
    }

    @Override
    public String toString() {
        return "Agente{" + "ideAgente='" + ideAgente + '\'' + ", codEstado='" + codEstado + '\'' + '}';
    }

}
