package co.com.foundation.client.rs.produccion.model;

import java.io.Serializable;

/**
 * Created by amartinez on 16/01/2018.
 */
public class Metadatos implements Serializable {

    private static final long serialVersionUID = 1L;
    private String nombreDocumento;
    private String nroRadicado;
    private String tipologiaDocumental;
    private String nombreRemitente;

    public Metadatos() {
    }

    public Metadatos(String nombreDocumento, String nroRadicado, String tipologiaDocumental, String nombreRemitente) {
        this.nombreDocumento = nombreDocumento;
        this.nroRadicado = nroRadicado;
        this.tipologiaDocumental = tipologiaDocumental;
        this.nombreRemitente = nombreRemitente;
    }

    public String getNroRadicado() {
        return nroRadicado;
    }

    public void setNroRadicado(String nroRadicado) {
        this.nroRadicado = nroRadicado;
    }

    public String getNombreDocumento() {
        return nombreDocumento;
    }

    public void setNombreDocumento(String nombreDocumento) {
        this.nombreDocumento = nombreDocumento;
    }

    public String getTipologiaDocumental() {
        return tipologiaDocumental;
    }

    public void setTipologiaDocumental(String tipologiaDocumental) {
        this.tipologiaDocumental = tipologiaDocumental;
    }


    public String getNombreRemitente() {
        return nombreRemitente;
    }

    public void setNombreRemitente(String nombreRemitente) {
        this.nombreRemitente = nombreRemitente;
    }

    @Override
    public String toString() {
        return "Metadatos{" +
                "nombreDocumento='" + nombreDocumento + '\'' +
                ", nroRadicado='" + nroRadicado + '\'' +
                ", tipologiaDocumental='" + tipologiaDocumental + '\'' +
                '}';
    }
}
