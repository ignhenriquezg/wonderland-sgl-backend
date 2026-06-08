package com.wonderland.sgl.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API REST - Wonderland Café SGL")
                        .version("1.0")
                        .description("Documentación interactiva del Sistema de Gestión Logística. Aquí puedes probar todos los endpoints del backend."));
    }
}