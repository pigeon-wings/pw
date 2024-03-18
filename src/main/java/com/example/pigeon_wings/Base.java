package com.example.pigeon_wings;


import com.example.pigeon_wings.factory.annotation.LazyAutowired;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.PostConstruct;

public abstract class Base {
    @LazyAutowired
    protected WebDriver driver;
    @LazyAutowired
    protected WebDriverWait wait;

    @PostConstruct
    private void init() {
        PageFactory.initElements(this.driver, this);
    }


    public abstract boolean isAt();


}
