package com.example.pigeon_wings.factory.config;


import com.example.pigeon_wings.factory.annotation.LazyConfiguration;
import com.example.pigeon_wings.factory.annotation.ThreadScopeBean;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

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
        WebDriverManager.chromedriver().driverVersion("122.0.6261.69").setup();
    return new ChromeDriver();
    }

}
