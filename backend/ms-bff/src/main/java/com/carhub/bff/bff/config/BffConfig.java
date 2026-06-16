package com.carhub.bff.bff.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class BffConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
