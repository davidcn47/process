package co.com.foundation.client.rs.transferencias;

import org.springframework.web.client.RestTemplate;

import co.com.foundation.client.constants.EstadosRespuesta;
import co.com.foundation.client.rs.gestionar.model.Agente;
import co.com.foundation.client.util.SystemParameters;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class ActualizarEstadosUDProxyCliente {

	private static ActualizarEstadosUDProxyCliente SINGLETON;
    private final String endpoint;
    private RestTemplate restTemplate;

    
    public ActualizarEstadosUDProxyCliente() {
        restTemplate = new RestTemplate();
        endpoint = "http://".concat(SystemParameters.getParameter(SystemParameters.BUSINESS_PLATFORM_ENDPOINT)).concat(
                "/correspondencia-business-services/services/agente-web-api/agente/actualizar-estado");
    }

    public static ActualizarEstadosUDProxyCliente getInstance() {
        if (SINGLETON == null)
            SINGLETON = new ActualizarEstadosUDProxyCliente();
        return SINGLETON;
    }
    
    
    public String actualizarEstadoUD() {
       // log.info("inicio - ejecutando servicio remoto - actualizarEstadoDestinatario : {}, {}", actualizarAgente, endpoint);
        try {
           // restTemplate.put(endpoint, actualizarAgente);
            return EstadosRespuesta.OK.name();
        } catch (Exception e) {
        //    log.error("error ejecutando servicio remoto - actualizarEstadoDestinatario: {}");
            return EstadosRespuesta.FALLO.name();
        } finally {
         //   log.info("fin - ejecutando servicio remoto - actualizarEstadoDestinatario : {}", actualizarAgente);
        }
    }
    
}
