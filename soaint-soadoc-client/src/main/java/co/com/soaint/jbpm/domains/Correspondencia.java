package co.com.soaint.jbpm.domains;

import java.io.Serializable;

public class Correspondencia implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nroRadicado;
    private String codEstado;

    public Correspondencia() {
        super();
    }

    public Correspondencia(String nroRadicado, String codEstado) {
        this.nroRadicado = nroRadicado;
        this.codEstado = codEstado;
    }

    public String getNroRadicado() {
        return nroRadicado;
    }

    public void setNroRadicado(String nroRadicado) {
        this.nroRadicado = nroRadicado;
    }

    public String getCodEstado() {
        return codEstado;
    }

    public void setCodEstado(String codEstado) {
        this.codEstado = codEstado;
    }

    @Override
    public String toString() {
        return "Correspondencia [nroRadicado=".concat(nroRadicado).concat(", codEstado=").concat(codEstado).concat("]");
    }
}
