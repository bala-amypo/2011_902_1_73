package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class Swagger {

    @Bean
    public OpenAPI customOpenAPI() {

        // 🔐 JWT Security Scheme
        SecurityScheme jwtScheme = new SecurityScheme()
                .name("Authorization")
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

        return new OpenAPI()
                // 🌍 Server
                .servers(List.of(
                        new Server().url("https://9026.408procr.amypo.ai/")
                ))

                // 🔒 Apply security globally
                .addSecurityItem(
                        new SecurityRequirement().addList("BearerAuth")
                )

                // 🔑 Register security scheme
                .components(
                        new Components().addSecuritySchemes(
                                "BearerAuth", jwtScheme
                        )
                );
    }
}