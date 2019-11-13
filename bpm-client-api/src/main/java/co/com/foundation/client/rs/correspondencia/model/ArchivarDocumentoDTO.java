package co.com.foundation.client.rs.correspondencia.model;

import java.io.Serializable;

public class ArchivarDocumentoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nroRadicado;
    private String codDependencia;
    private String usuarioProyectorRadicador;

    public ArchivarDocumentoDTO() {
        super();
    }

    public ArchivarDocumentoDTO(String nroRadicado, String codDependencia, String usuarioProyectorRadicador) {
        this.nroRadicado = nroRadicado;
        this.codDependencia = codDependencia;
        this.usuarioProyectorRadicador = usuarioProyectorRadicador;
    }

    public String getNroRadicado() {
        return nroRadicado;
    }

    public void setNroRadicado(String nroRadicado) {
        this.nroRadicado = nroRadicado;
    }

    public String getCodDependencia() {
        return codDependencia;
    }

    public void setCodDependencia(String codDependencia) {
        this.codDependencia = codDependencia;
    }

    public String getUsuarioProyectorRadicador() {
        return usuarioProyectorRadicador;
    }

    public void setUsuarioProyectorRadicador(String usuarioProyectorRadicador) {
        this.usuarioProyectorRadicador = usuarioProyectorRadicador;
    }

    @Override
    public String toString() {
        return "Correspondencia [nroRadicado=".concat(nroRadicado).concat(", codDependencia=").concat(codDependencia).concat(", usuarioProyectorRadicador").concat(usuarioProyectorRadicador).concat("]");
    }
}
