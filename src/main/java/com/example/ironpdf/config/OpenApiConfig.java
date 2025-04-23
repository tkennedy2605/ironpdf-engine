package com.example.ironpdf.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: nguyendinhthi
 * Date: 23/4/25
 */

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI ironPdfOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("IronPDF Service API")
                        .description("API endpoints for generating PDFs and managing license")
                        .version("v1.0")
                );
    }
}