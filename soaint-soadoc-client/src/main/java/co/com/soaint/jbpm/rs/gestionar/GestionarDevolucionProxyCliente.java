package co.com.soaint.jbpm.rs.gestionar;

import co.com.soaint.jbpm.constants.EstadosRespuesta;
import co.com.soaint.jbpm.domains.InvocarSignal;
import co.com.soaint.jbpm.util.SystemParameters;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Arce on 8/25/2017.
 */
@Log4j2
public class GestionarDevolucionProxyCliente {

    private static GestionarDevolucionProxyCliente SINGLETON;
    private final String endpointGateway;
    private RestTemplate restTemplate;

    public GestionarDevolucionProxyCliente() {
        restTemplate = new RestTemplate();
        endpointGateway = SystemParameters.getParameter(SystemParameters.API_GATEWAY_ENDPOINT).concat(
                "/proceso-gateway-api/send-signal");
    }

    public static GestionarDevolucionProxyCliente getInstance() {
        if (SINGLETON == null)
            SINGLETON = new GestionarDevolucionProxyCliente();
        return SINGLETON;
    }

    /**
     * Permite guardar la instancia de proceso
     *
     * @param entrada Objeto que contiene los datos para llamada a la sennal
     * @return ENUM con estado OK o Fallo teniendo en cuenta la respuesta del servicio
     */
    public String enviarSennal(InvocarSignal entrada) {
        log.info("inicio - ejecutando  - enviarSennalGestorDevoluciones : {}, {}", entrada, endpointGateway);
        try {
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
            headers.add("Accept", "application/json");
            headers.add("Content-Type", "application/json");
            restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
            HttpEntity<InvocarSignal> request = new HttpEntity<InvocarSignal>(entrada, headers);
            restTemplate.postForLocation(endpointGateway, request);
            return EstadosRespuesta.OK.name();
        } catch (Exception e) {
            log.error("error ejecutando enviarSennal - enviarSennal: {}" + endpointGateway);
            return EstadosRespuesta.FALLO.name();
        } finally {
            log.info("fin - ejecutando enviarSennalGestorDevoluciones - enviarSennalGestorDevoluciones : {}", entrada);
        }
    }

}
