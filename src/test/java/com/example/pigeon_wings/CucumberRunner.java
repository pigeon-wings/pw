package com.example.pigeon_wings;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(

        features = "classpath:features",
        glue = "com.example.pigeon_wing.BDD",
        //tags = "not @google",
        //tags = "@google",
        plugin = {
                "pretty",
                "html:D:/SpringBootCourse/IntellijWorkSpace/screenshotStore/report_nop.html"

        }

)
public class CucumberRunner extends AbstractTestNGCucumberTests {

//        @Override
//        @DataProvider(parallel = true)
//        public Object[][] scenarios() {
//                return super.scenarios();
//        }
}
