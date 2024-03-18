package com.example.pigeon_wings.BDD;


import com.example.pigeon_wings.Base;
import com.example.pigeon_wings.factory.annotation.LazyAutowired;
import com.example.pigeon_wings.factory.service.ScreenshotService;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.springframework.context.ApplicationContext;

import java.io.IOException;


public class CucumberHooks extends Base {
    @LazyAutowired
    private ScreenshotService screenshotService;
    @LazyAutowired
    private ApplicationContext applicationContext;

    @AfterStep
    public void afterStep(Scenario scenario) throws IOException {

        if (scenario.isFailed()) {

            byte[] byteArray = this.screenshotService.getScreenshotService();
            scenario.attach(byteArray, "image/png", scenario.getName());

        }
    }
   // @After
   // public void afterScenario(){
    //        this.applicationContext.getBean(WebDriver.class).quit();
    //    }




    @Override
    public boolean isAt() {
        return false;
    }

}
