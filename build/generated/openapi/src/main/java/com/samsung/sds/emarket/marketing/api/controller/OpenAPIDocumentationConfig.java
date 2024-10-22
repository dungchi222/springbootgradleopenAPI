package com.samsung.sds.emarket.marketing.api.controller;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.customizers.OpenApiCustomiser;

@Configuration
public class OpenAPIDocumentationConfig {

    @Bean
    public GroupedOpenApi api() {
        return GroupedOpenApi.builder()
                .group("marketing-api")
                .packagesToScan("com.samsung.sds.emarket.marketing.api.controller") // Scan your controller package
                .pathsToMatch("/api/v1/**")
                .build();
    }

    @Bean
    public OpenApiCustomiser openApiCustomiser() {
        return openApi -> openApi.info(
                new Info()
                        .title("Emarket API")
                        .description("The Marketing Service HTTP API")
                        .version("v1")
                        .contact(new Contact()
                                .name("Support Team")
                                .email("support@emarket.com")
                                .url("http://support.emarket.com"))
        );
    }
}
