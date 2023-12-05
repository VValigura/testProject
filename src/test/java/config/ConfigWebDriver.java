package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class ConfigWebDriver {

    private final WebDriverConfig config;

    public ConfigWebDriver() {
        this.config = ConfigFactory.create(WebDriverConfig.class, System.getProperties());
    }


    public void setBrowserConfig(){
        Configuration.browserSize = config.getBrowserSize();
        Configuration.browser = config.getBrowserName();
    }

    public void addRemoteSelenide(){
        Configuration.remote = config.getSelenoidUrl();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }
}
