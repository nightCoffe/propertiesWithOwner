package configurations;

import org.aeonbits.owner.Config;


@Config.Sources({
        "file:/tmp/secret.properties",
        "classpath:config/${environment}.properties"
})

public interface ApiConfig extends Config{

    @Key("baseUrl")
    @DefaultValue("https://habr.com")
    String getBaseUrl();

    @Key("token")
    String getToken();
}

