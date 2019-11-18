package co.com.foundation.client.rs.gestionar.model;

import java.io.Serializable;
import java.util.Map;

/**
 * Created by Arce on 8/25/2017.
 */
public class InvocarSignal implements Serializable {
    private static final long serialVersionUID = -5692073949092232892L;
    private String idDespliegue;
    private Map<String, Object> parametros;

    public InvocarSignal() {

    }

    public InvocarSignal(String idDespliegue, Map<String, Object> parametros) {
        this.idDespliegue = idDespliegue;
        this.parametros = parametros;
    }

    public String getIdDespliegue() {
        return idDespliegue;
    }

    public void setIdDespliegue(String idDespliegue) {
        this.idDespliegue = idDespliegue;
    }

    public Map<String, Object> getParametros() {
        return parametros;
    }

    public void setParametros(Map<String, Object> parametros) {
        this.parametros = parametros;
    }

    @Override
    public String toString() {
        return "InvocarSignal{" +
                "idDespliegue='" + idDespliegue + '\'' +
                ", parametros=" + parametros +
                '}';
    }
}
