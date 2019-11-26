package co.com.soaint.jbpm.rs.correspondencia;

import co.com.soaint.jbpm.constants.EstadosRespuesta;
import co.com.soaint.jbpm.domains.Correspondencia;
import co.com.soaint.jbpm.util.SystemParameters;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Arce on 06/14/2017.
 */

@Log4j2
public class ActualizarEstadoRadicacionProxyCliente {


    private static ActualizarEstadoRadicacionProxyCliente SINGLETON;
    private final String endpoint;
    private RestTemplate restTemplate;


    private ActualizarEstadoRadicacionProxyCliente() {
        restTemplate = new RestTemplate();
        endpoint = "http://".concat(SystemParameters.getParameter(SystemParameters.BUSINESS_PLATFORM_ENDPOINT)).concat(
                "/correspondencia-business-services/services/correspondencia-web-api/correspondencia/actualizar-estado");
    }

    // -------------------------

    public static ActualizarEstadoRadicacionProxyCliente getInstance() {
        if (SINGLETON == null)
            SINGLETON = new ActualizarEstadoRadicacionProxyCliente();
        return SINGLETON;
    }

    // -------------------------

    public String actualizarEstadoRadicacion(final Correspondencia correspondencia) {

        log.info("inicio - ejecutando servicio remoto - actualizarEstadoRadicacion : {}, {}", correspondencia, endpoint);

        try {

            restTemplate.put(endpoint, correspondencia);
            return EstadosRespuesta.OK.name();

        } catch (Throwable e) {
            log.error("error ejecutando servicio remoto - actualizarEstadoRadicacion: {}");
            return EstadosRespuesta.FALLO.name();
        } finally {
            log.info("fin - ejecutando servicio remoto - actualizarEstadoRadicacion : {}", correspondencia);
        }
    }

}
