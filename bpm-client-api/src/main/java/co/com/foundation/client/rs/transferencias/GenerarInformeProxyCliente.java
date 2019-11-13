package co.com.foundation.client.rs.transferencias;

import org.springframework.web.client.RestTemplate;

import co.com.foundation.client.constants.EstadosRespuesta;
import co.com.foundation.client.rs.gestionar.model.Agente;
import co.com.foundation.client.util.SystemParameters;

public class GenerarInformeProxyCliente {

	private static GenerarInformeProxyCliente SINGLETON;
    private final String endpoint;
    private RestTemplate restTemplate;

    
    public GenerarInformeProxyCliente() {
        restTemplate = new RestTemplate();
        endpoint = "http://".concat(SystemParameters.getParameter(SystemParameters.BUSINESS_PLATFORM_ENDPOINT)).concat(
                "/correspondencia-business-services/services/agente-web-api/agente/actualizar-estado");
    }

    public static GenerarInformeProxyCliente getInstance() {
        if (SINGLETON == null)
            SINGLETON = new GenerarInformeProxyCliente();
        return SINGLETON;
    }
    
    
    public String generarInformeTransferencia() {
       // log.info("inicio - ejecutando servicio remoto - actualizarEstadoDestinatario : {}, {}", actualizarAgente, endpoint);
        try {
         //   restTemplate.put(endpoint, actualizarAgente);
            return EstadosRespuesta.OK.name();
        } catch (Exception e) {
        //    log.error("error ejecutando servicio remoto - actualizarEstadoDestinatario: {}");
            return EstadosRespuesta.FALLO.name();
        } finally {
         //   log.info("fin - ejecutando servicio remoto - actualizarEstadoDestinatario : {}", actualizarAgente);
        }
    }
}
