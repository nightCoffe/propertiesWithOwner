package tests;

import configurations.ApiConfig;
import configurations.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AssertConfigurationsFile {

    @Test
    public void browserLocalTest() {
        System.setProperty("environment", "browserLocal");
        WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
        assertThat(webConfig.getBrowser()).isEqualTo("CHROME");
        assertThat(webConfig.getBrowserVersion()).isEqualTo("96.0");
    }

    @Test
    public void defaultBrowserLocalTest() {
        WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
        assertThat(webConfig.getBrowser()).isEqualTo("CHROME");
        assertThat(webConfig.getBrowserVersion()).isEqualTo("95.0");
    }

    @Test
    public void remoteDataTest() {
        System.setProperty("environment", "remote");
        WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
        assertThat(webConfig.getBrowser()).isEqualTo("FIREFOX");
        assertThat(webConfig.getBrowserVersion()).isEqualTo("95.0");
        assertThat(webConfig.getRemoteDriver()).isEqualTo("https://user1:1234@selenoid.autotests.cloud/wd/hub/");
    }

    @Test
    public void apiConfigTest() {
        System.setProperty("environment", "api");
        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
        assertThat(apiConfig.getBaseUrl()).isEqualTo("https://habr.com");
        assertThat(apiConfig.getToken()).isEqualTo("Token");
    }
}
