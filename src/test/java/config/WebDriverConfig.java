package config;

import org.aeonbits.owner.Config;


@Config.Sources({
        "classpath:testing1.properties"
})
public interface WebDriverConfig extends Config {
    @Key("browser_size")
    String getBrowserSize();

    @Key("browser_name")
    String getBrowserName();

    @Key("browser_version")
    String getBrowserVersion();

    @Key("selenoid_url")
    String getSelenoidUrl();



}
