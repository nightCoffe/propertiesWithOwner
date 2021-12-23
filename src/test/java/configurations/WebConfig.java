package configurations;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:config/${environment}.properties")

public interface WebConfig extends Config {

    @Key("browser")
    @DefaultValue("CHROME")
    String getBrowser();

    @Key("browserVersion")
    @DefaultValue("95.0")
    String getBrowserVersion();

    @Key("baseUrl")
    @DefaultValue("https://habr.com")
    String getBaseUrl();

    @Key("remoteDriver")
    String getRemoteDriver();
}
