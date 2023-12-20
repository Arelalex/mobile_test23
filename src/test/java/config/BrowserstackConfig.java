package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:browserstack.properties"
})

public interface BrowserstackConfig extends Config {

    @Key("build")
    String getBuild();

    @Key("URL")
    String getURL();
}
