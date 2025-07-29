package com.example.employee_client.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI employeeServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employee Client API")
                        .version("1.0.0")
                        .description("This service call all Employee Service CRUD operations using Web Client")
                        .termsOfService("https://yourcompany.com/terms")
                        .contact(new Contact()
                                .name("Tech Team")
                                .url("https://yourcompany.com")
                                .email("support@yourcompany.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")));
    }
}
