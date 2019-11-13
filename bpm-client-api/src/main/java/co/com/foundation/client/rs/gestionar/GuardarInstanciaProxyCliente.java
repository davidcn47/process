package co.com.foundation.client.rs.gestionar;

import co.com.foundation.client.constants.EstadosRespuesta;
import co.com.foundation.client.rs.gestionar.model.GuardarInstancia;
import co.com.foundation.client.util.SystemParameters;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Arce on 7/14/2017.
 */
@Log4j2
public class GuardarInstanciaProxyCliente {

    private static GuardarInstanciaProxyCliente SINGLETON;
    private final String endpoint;
    private RestTemplate restTemplate;

    public GuardarInstanciaProxyCliente() {
        restTemplate = new RestTemplate();
        endpoint = "http://".concat(SystemParameters.getParameter(SystemParameters.BUSINESS_PLATFORM_ENDPOINT)).concat(
                "/correspondencia-business-services/services/asignacion-web-api/asignacion/actualizar-instancia");
    }

    public static GuardarInstanciaProxyCliente getInstance() {
        if (SINGLETON == null)
            SINGLETON = new GuardarInstanciaProxyCliente();
        return SINGLETON;
    }

    /**
     * Permite guardar la instancia de proceso
     *
     * @param guardarInstancia Objeto que contiene ideAsignacion y idInstancia
     * @return ENUM con estado OK o Fallo teniendo en cuenta la respuesta del servicio
     */
    public String guardarInstanciaProceso(GuardarInstancia guardarInstancia) {
        log.info("inicio - ejecutando servicio remoto - guardarInstanciaProceso : {}, {}", guardarInstancia, endpoint);
        try {
            restTemplate.put(endpoint, guardarInstancia);
            return EstadosRespuesta.OK.name();
        } catch (Exception e) {
            log.error("error ejecutando servicio remoto - guardarInstanciaProceso: {}");
            return EstadosRespuesta.FALLO.name();
        } finally {
            log.info("fin - ejecutando servicio remoto - guardarInstanciaProceso : {}", guardarInstancia);
        }
    }
}
