package co.com.soaint.jbpm.rs.gestionar;

import co.com.soaint.jbpm.constants.EstadosRespuesta;
import co.com.soaint.jbpm.rs.gestionar.model.Agente;
import co.com.soaint.jbpm.util.SystemParameters;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Arce on 7/14/2017.
 */
@Log4j2
public class ActualizarEstadoDestinatarioProxyCliente {
    private static ActualizarEstadoDestinatarioProxyCliente SINGLETON;
    private final String endpoint;
    private RestTemplate restTemplate;


    public ActualizarEstadoDestinatarioProxyCliente() {
        restTemplate = new RestTemplate();
        endpoint = "http://".concat(SystemParameters.getParameter(SystemParameters.BUSINESS_PLATFORM_ENDPOINT)).concat(
                "/correspondencia-business-services/services/agente-web-api/agente/actualizar-estado");
    }

    public static ActualizarEstadoDestinatarioProxyCliente getInstance() {
        if (SINGLETON == null)
            SINGLETON = new ActualizarEstadoDestinatarioProxyCliente();
        return SINGLETON;
    }

    /**
     * Permite redireccionar la correspondencia
     *
     * @param actualizarAgente Objeto que contiene ideAgente y codEstado
     * @return ENUM con estado OK o Fallo teniendo en cuenta la respuesta del servicio
     */
    public String actualizarEstadoDestinatario(Agente actualizarAgente) {
        log.info("inicio - ejecutando servicio remoto - actualizarEstadoDestinatario : {}, {}", actualizarAgente, endpoint);
        try {
            restTemplate.put(endpoint, actualizarAgente);
            return EstadosRespuesta.OK.name();
        } catch (Exception e) {
            log.error("error ejecutando servicio remoto - actualizarEstadoDestinatario: {}");
            return EstadosRespuesta.FALLO.name();
        } finally {
            log.info("fin - ejecutando servicio remoto - actualizarEstadoDestinatario : {}", actualizarAgente);
        }
    }
}
