package com.example.employee_service.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI employeeServiceOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Employee Management Microservice API")
                        .version("1.0.0")
                        .description("This service handles all Employee CRUD operations such as creating, updating, retrieving, and deleting employee data.")
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
