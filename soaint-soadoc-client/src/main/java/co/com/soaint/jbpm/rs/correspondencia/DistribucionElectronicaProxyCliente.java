package co.com.soaint.jbpm.rs.correspondencia;

import co.com.soaint.jbpm.constants.EstadosRespuesta;
import co.com.soaint.jbpm.util.SystemParameters;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Log4j2
public class DistribucionElectronicaProxyCliente {

    private static DistribucionElectronicaProxyCliente SINGLETON;
    private final String endpoint;
    private RestTemplate restTemplate;

    public DistribucionElectronicaProxyCliente() {
        endpoint = "http://".concat(SystemParameters.getParameter(SystemParameters.BUSINESS_PLATFORM_ENDPOINT)).concat("/correspondencia-business-services/services/correspondencia-web-api/correspondencia/enviar-correo/");
        restTemplate = new RestTemplate();

    }

    public static DistribucionElectronicaProxyCliente getInstance() {
        if (SINGLETON == null)
            SINGLETON = new DistribucionElectronicaProxyCliente();
        return SINGLETON;
    }

    public String distribucionElectronica(String numeroRadicado) {

        log.info("inicio - ejecutando servicio remoto - DistribucionElectronica : {}, {}", numeroRadicado, endpoint);

        try {


            MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
            headers.add("Accept", "application/json");
            restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
            restTemplate.getForObject(endpoint.concat(numeroRadicado), String.class);

            return EstadosRespuesta.OK.name();
        } catch (Throwable e) {
            log.error("error ejecutando servicio remoto - DistribucionElectronica: ///".concat(e.getMessage()));
            return EstadosRespuesta.FALLO.name();
        } finally {
            log.info("fin - ejecutando servicio remoto - DistribucionElectronica : {}");

        }
    }
}
