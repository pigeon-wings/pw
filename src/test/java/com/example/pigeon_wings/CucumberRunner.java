package com.example.pigeon_wings;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;
import org.springframework.scheduling.annotation.Scheduled;
import org.testng.annotations.DataProvider;

@CucumberOptions(

        features = {"classpath:features"},
        glue = "com.example.pigeon_wings.BDD",
        tags = "@test-1 or @test-2",
        plugin = {
                "pretty",
                "html:D:/SpringBootCourse/IntellijWorkSpace/screenshotStore/report_nop.html"

        }

)

public class CucumberRunner extends AbstractTestNGCucumberTests {
        @Override
        @DataProvider(parallel = false)
        public Object[][] scenarios() {
                return super.scenarios();
        }


}
