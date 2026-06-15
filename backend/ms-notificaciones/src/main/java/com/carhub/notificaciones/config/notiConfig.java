package com.carhub.notificaciones.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;


@Configuration
public class notiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
                    .title("Api del microservicio de aplicaciones")
                    .version("1.0.0")
                    .description("Documentacion de endpoints para envio de alerta")
                    .contact(new Contact()
                            .name("Equipo mensajeria")
                            .email("mensajeria@carhub.com")));
    }
}