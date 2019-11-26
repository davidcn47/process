package co.com.soaint.jbpm.rs.produccion;

import co.com.soaint.jbpm.constants.EstadosRespuesta;
import co.com.soaint.jbpm.rs.gestionar.model.InvocarSignal;
import co.com.soaint.jbpm.rs.produccion.model.Metadatos;
import co.com.soaint.jbpm.util.SystemParameters;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by amartinez on 16/01/2018.
 */

@Log4j2
public class ActualizarMetadatosAnexosProxyCliente {

    private static ActualizarMetadatosAnexosProxyCliente SINGLETON;
    private final String endpoint;
    private RestTemplate restTemplate;

//    public ActualizarMetadatosAnexosProxyCliente() {
//        restTemplate = new RestTemplate();
//        endpoint = "http://".concat(SystemParameters.getParameter(SystemParameters.BUSINESS_PLATFORM_ENDPOINT)).concat(
//                "/ecm-integration-services/apis/ecm/modificarMetadatosDocumentoECM");
//    }

    public ActualizarMetadatosAnexosProxyCliente() {
        restTemplate = new RestTemplate();
        endpoint = "http://192.168.1.154:28080/ecm-integration-services/apis/ecm/modificarMetadatosDocumentoECM";
    }

    public static ActualizarMetadatosAnexosProxyCliente getInstance() {
        if (SINGLETON == null)
            SINGLETON = new ActualizarMetadatosAnexosProxyCliente();
        return SINGLETON;
    }

    /**
     * Permite actualizar los metadatos Anexos
     *
     * @param actualizarMetadatos Objeto que contiene ideAgente y codEstado
     * @return ENUM con estado OK o Fallo teniendo en cuenta la respuesta del servicio
     */
    public String actualizarMetadatosAnexos(Metadatos actualizarMetadatos) {
        log.info("inicio - ejecutando servicio remoto - actualizar metadatos anexos  : {}, {}", actualizarMetadatos, endpoint);
        try {
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
            headers.add("Accept", "application/json");
            headers.add("Content-Type", "application/json");
            restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
            HttpEntity<Metadatos> request = new HttpEntity<Metadatos>(actualizarMetadatos, headers);
            restTemplate.postForLocation(endpoint, request);
            return EstadosRespuesta.OK.name();
        } catch (Exception e) {
            log.error("error ejecutando servicio remoto - actualizar metadatos anexos: {}");
            return EstadosRespuesta.FALLO.name();
        } finally {
            log.info("fin - ejecutando servicio remoto - actualizar metadatos anexos : {}", actualizarMetadatos);
        }
    }
}

