package co.com.foundation.client.rs.correspondencia.model;

import java.io.Serializable;

/**
 * Created by Ernesto on 2017-07-19.
 */
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nroRadicado;
    private String ideEcm;

    public Documento() {
        super();
    }

    public Documento(String nroRadicado, String ideEcm) {
        this.nroRadicado = nroRadicado;
        this.ideEcm = ideEcm;
    }

    public String getNroRadicado() {
        return nroRadicado;
    }

    public void setNroRadicado(String nroRadicado) {
        this.nroRadicado = nroRadicado;
    }

    public String getIdeEcm() {
        return ideEcm;
    }

    public void setIdeEcm(String ideEcm) {
        this.ideEcm = ideEcm;
    }

    @Override
    public String toString() {
        return "Documento [nroRadicado=".concat(nroRadicado).concat(", ideEcm=").concat(ideEcm).concat("]");
    }
}
