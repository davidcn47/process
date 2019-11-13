package co.com.foundation.client.rs.correspondencia;

import co.com.foundation.client.constants.EstadosRespuesta;
import co.com.foundation.client.util.SystemParameters;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Log4j2
public class AlertaElectronicaProxyCliente {

    private static AlertaElectronicaProxyCliente SINGLETON;
    private final String endpoint;
    private RestTemplate restTemplate;

    public AlertaElectronicaProxyCliente(){
        endpoint = "http://".concat(SystemParameters.getParameter(SystemParameters.BUSINESS_PLATFORM_ENDPOINT)).concat
                ("/correspondencia-business-services/services/correspondencia-web-api/correspondencia/correo-vencimiento/");
        restTemplate = new RestTemplate();
    }

    public static AlertaElectronicaProxyCliente getInstance() {
        if (SINGLETON == null)
            SINGLETON = new AlertaElectronicaProxyCliente();
        return SINGLETON;
    }

    public String alertaElectronica(String numeroRadicado) {

        log.info("inicio - ejecutando servicio remoto - AlertaElectronica : {}, {}", numeroRadicado, endpoint);

        try {
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
            headers.add("Accept", "application/json");
            restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
            restTemplate.getForObject(endpoint.concat(numeroRadicado), Boolean.class);
            return EstadosRespuesta.OK.name();
        } catch (Throwable e) {
            log.error("error ejecutando servicio remoto - AlertaElectronica: ///".concat(e.getMessage()));
            return EstadosRespuesta.FALLO.name();
        } finally {
            log.info("fin - ejecutando servicio remoto - AlertaElectronica : {}");
        }
    }
}

