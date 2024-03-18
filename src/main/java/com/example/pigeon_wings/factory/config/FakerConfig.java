package com.example.pigeon_wings.factory.config;


import com.example.pigeon_wings.factory.annotation.LazyConfiguration;
import com.github.javafaker.Faker;
import org.springframework.context.annotation.Bean;

@LazyConfiguration
public class FakerConfig {
    @Bean
    public Faker getFaker(){
        return new Faker();
    }
}
