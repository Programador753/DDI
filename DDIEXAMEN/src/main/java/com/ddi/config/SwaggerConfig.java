package com.ddi.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class that contains the Swagger and OpenAPI configuration.
 *
 * @author Antonio
 */
@Configuration
public class SwaggerConfig {

    /**
     * Pre: -
     * Post: returns the OpenAPI object configured with JWT security scheme.
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gestión de Eventos Deportivos")
                        .version("1.0")
                        .description("Documentación de la API con seguridad JWT"))
                .components(new Components().addSecuritySchemes("BearerAuth", new SecurityScheme()
                        .name("BearerAuth")
                        .type(SecurityScheme.Type.HTTP)
                        .scheme("bearer")
                        .bearerFormat("JWT")));
    }
}