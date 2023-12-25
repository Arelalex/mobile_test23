package config;


import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${platform}.properties"
})

public interface MobileConfig extends Config {

    @Key("deviceModel")
    String getDeviceModel();

    @Key("deviceVersion")
    String getDeviceVersion();

    @Key("appUrl")
    String getAppUrl();
}