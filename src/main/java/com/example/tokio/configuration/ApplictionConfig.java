package com.example.tokio.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplictionConfig {

    @Bean
    public ModelMapper modelMapper() {

        return new ModelMapper();
    }
}
