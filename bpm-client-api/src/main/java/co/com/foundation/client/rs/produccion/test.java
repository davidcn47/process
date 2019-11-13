package co.com.foundation.client.rs.produccion;

import co.com.foundation.client.rs.produccion.model.Metadatos;
import co.com.soaint.foundation.canonical.bpm.EntradaProcesoDTO;


/**
 * Created by amartinez on 10/01/2018.
 */
public  class test {


    public static void main (String [] args) {

        ActualizarMetadatosAnexosProxyCliente api = ActualizarMetadatosAnexosProxyCliente.getInstance();

        Metadatos actualizar = new Metadatos();

        actualizar.setNombreDocumento("TUTELA");
        actualizar.setNombreRemitente("Arce");
        actualizar.setNroRadicado("ASQ-124523");
        actualizar.setTipologiaDocumental("TP");

        String tx = api.actualizarMetadatosAnexos(actualizar);

        System.out.print(tx);
    }
}
