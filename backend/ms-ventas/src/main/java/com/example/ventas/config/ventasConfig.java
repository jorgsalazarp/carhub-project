package com.example.ventas.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class ventasConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                .title("API de Ventas")
                .version("1.0.0")
                .description("API para gestionar las ventas en CarHub")
                .contact(new Contact()
                    .name("Contrato de Ventas")
                    .email("carhubsoporte@gmail.com")));
    }
}