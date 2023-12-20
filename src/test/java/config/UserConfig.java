package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:user.properties"
})

public interface UserConfig extends Config {

    @Key("userName")
    String getUserName();

    @Key("accessKey")
    String getAccessKey();
}