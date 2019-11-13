package co.com.foundation.client.util;

public class SystemParameters {

    public static final String BUSINESS_PLATFORM_ENDPOINT = "business-platform-endpoint";

    private SystemParameters() {
    }

    public static String getParameter(final String parameterName) {
        return System.getProperty(parameterName);
    }

}
