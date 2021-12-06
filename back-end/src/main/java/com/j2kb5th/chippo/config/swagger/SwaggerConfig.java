package com.j2kb5th.chippo.config.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    // basic setting
    @Bean
    public OpenAPI chippoAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("CHIPPO API")
                        .description("CHIPPO api specification")
                        .contact(new Contact().name("@dadahee, @nrudev"))
                );
    }

    @Bean
    public GroupedOpenApi apiVersion() {
        return GroupedOpenApi.builder()
                .group("api-v1")
                .pathsToExclude("/swagger") // 제외 url
                .pathsToMatch("/**") // 처리될 url
                .build();
    }
}
