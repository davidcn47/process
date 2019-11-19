package co.com.soaint.jbpm.util;

public class SystemParameters {

    public static final String BUSINESS_PLATFORM_ENDPOINT = "business-platform-endpoint";
    public static final String BPM_PLATFORM_ENDPOINT = "bpm-platform-endpoint";
    public static final String API_GATEWAY_ENDPOINT = "apigateway.host";

    private SystemParameters() {
    }

    public static String getParameter(final String parameterName) {
        return System.getProperty(parameterName);
    }

}
