package co.com.soaint.jbpm.rs.correspondencia;

import co.com.soaint.jbpm.constants.EstadosRespuesta;
import co.com.soaint.jbpm.rs.correspondencia.model.Documento;
import co.com.soaint.jbpm.util.SystemParameters;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Ernesto on 07/18/2017.
 */
@Log4j2
public class ActualizarReferenciaEcmProxyCliente {

    private static ActualizarReferenciaEcmProxyCliente SINGLETON;
    private final String endpoint;
    private RestTemplate restTemplate;


    private ActualizarReferenciaEcmProxyCliente() {
        restTemplate = new RestTemplate();
        endpoint = "http://".concat(SystemParameters.getParameter(SystemParameters.BUSINESS_PLATFORM_ENDPOINT)).concat(
                "/correspondencia-business-services/services/documento-web-api/documento/actualizar-referencia-ecm");
    }

    public static ActualizarReferenciaEcmProxyCliente getInstance() {
        if (SINGLETON == null)
            SINGLETON = new ActualizarReferenciaEcmProxyCliente();
        return SINGLETON;
    }

    /**
     * Permite actualizar la referencia del ECM
     *
     * @param documento Objeto que contiene nroRadicado y ideEcm
     * @return ENUM con estado OK o Fallo teniendo en cuenta la respuesta del servicio
     */
    public String actualizarReferenciaECM(final Documento documento) {

        log.info("inicio - ejecutando servicio remoto - actualizarReferenciaECM : {}, {}", documento, endpoint);

        try {
            restTemplate.put(endpoint, documento);
            return EstadosRespuesta.OK.name();
        } catch (Throwable e) {
            log.error("error ejecutando servicio remoto - actualizarReferenciaECM: {}");
            return EstadosRespuesta.FALLO.name();
        } finally {
            log.info("fin - ejecutando servicio remoto - actualizarReferenciaECM : {}", documento);
        }

    }

}
