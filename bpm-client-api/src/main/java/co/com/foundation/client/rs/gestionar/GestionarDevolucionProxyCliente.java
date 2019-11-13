package co.com.foundation.client.rs.gestionar;

import co.com.foundation.client.constants.EstadosRespuesta;
import co.com.foundation.client.rs.gestionar.model.InvocarSignal;
import co.com.foundation.client.util.SystemParameters;
import co.com.soaint.foundation.canonical.bpm.EntradaProcesoDTO;
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
    private final String endpoint;
    private RestTemplate restTemplate;

    public GestionarDevolucionProxyCliente() {
        restTemplate = new RestTemplate();
        endpoint = "http://".concat(SystemParameters.getParameter(SystemParameters.BUSINESS_PLATFORM_ENDPOINT)).concat(
                "/bpm-integration-services/apis/bpm/proceso/sennal/inicio/");
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
    public String enviarSennal(InvocarSignal entrada ) {
        log.info("inicio - ejecutando  - enviarSennalGestorDevoluciones : {}, {}", entrada, endpoint);
        try {
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
            headers.add("Accept", "application/json");
            headers.add("Content-Type", "application/json");
            restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
            HttpEntity<InvocarSignal> request = new HttpEntity<InvocarSignal>(entrada, headers);
            restTemplate.postForLocation(endpoint, request);
            return EstadosRespuesta.OK.name();
        } catch (Exception e) {
            log.error("error ejecutando enviarSennalGestorDevoluciones - enviarSennalGestorDevoluciones: {}");
            return EstadosRespuesta.FALLO.name();
        } finally {
            log.info("fin - ejecutando enviarSennalGestorDevoluciones - enviarSennalGestorDevoluciones : {}", entrada);
        }
    }

}
