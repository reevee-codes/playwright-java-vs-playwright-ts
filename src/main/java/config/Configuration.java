package config;

public class Configuration {
    private static final String BASE_URL = System.getProperty("baseUrl", "https://ultimateqa.com");

    private static final String BROWSER = System.getProperty("browser", "chromium");

    private static final boolean HEADLESS = Boolean.parseBoolean(System.getProperty("headless", "false"));

    public static String getBaseUrl() {
        return BASE_URL;
    }
    public static class Paths {
        public static final String COMPLICATED_PAGE = "/complicated-page";
    }

    public static String getBrowser() {
        return BROWSER;
    }

    public static boolean isHeadless() {
        return HEADLESS;
    }

    public static String getFullUrl(String path) {
        return BASE_URL + path;
    }
} 