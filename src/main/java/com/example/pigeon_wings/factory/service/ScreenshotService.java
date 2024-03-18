package com.example.pigeon_wings.factory.service;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Lazy
@Service
public class ScreenshotService {

    @Autowired
    private ApplicationContext ctx;

//    @Value("${screenshot.path}")
//    private Path path;
//    @Autowired
//    private Faker faker;
//
//    public void takeScreenShot() throws IOException {
//        File sourceFile = this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.FILE);
//        FileCopyUtils.copy(sourceFile, this.path.resolve(faker.name().firstName() + ".png").toFile());
//    }
    public byte[] getScreenshotService() throws IOException {
       //return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

       return this.ctx.getBean(TakesScreenshot.class).getScreenshotAs(OutputType.BYTES);


    }



}
