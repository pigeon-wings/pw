package com.example.pigeon_wings.factory.scope;


import com.example.pigeon_wings.factory.annotation.LazyConfiguration;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class BrowserScopeConfig {
    @Bean
    public static BeanFactoryPostProcessor beanFactoryPostProcessor(){

        return new BrowserScopePostProcessor();
    }



}
