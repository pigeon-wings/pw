package com.example.pigeon_wings.factory.config;


import com.example.pigeon_wings.factory.annotation.LazyConfiguration;
import com.example.pigeon_wings.factory.annotation.ThreadScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.util.HashMap;
import java.util.Map;

@LazyConfiguration
public class WebDriverConfig {

    @ThreadScopeBean
    @ConditionalOnProperty(name="browser", havingValue = "firefox")
    public WebDriver firefoxDriver(){
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();

    }

@ThreadScopeBean
@ConditionalOnProperty(name="browser", havingValue = "chrome")
@ConditionalOnMissingBean
    public WebDriver chromeDriver(){
    ChromeOptions chromeOptions = new ChromeOptions();
    Map<String, Object> prefs = new HashMap<String, Object>();
    prefs.put("profile.default_content_setting_values.notifications", 2);
    prefs.put("autofill.profile_enabled", false);
    chromeOptions.setExperimentalOption("prefs", prefs);
    //chromeOptions.addArguments("--disable-popup-blocking");
        WebDriverManager.chromedriver().driverVersion("122.0.6261.69").setup();

    return new ChromeDriver(chromeOptions);
    }

}
