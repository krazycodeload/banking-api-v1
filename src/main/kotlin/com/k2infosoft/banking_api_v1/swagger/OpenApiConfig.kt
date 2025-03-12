package com.k2infosoft.banking_api_v1.swagger

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class OpenApiConfig {
    @Bean
    fun customOpenAPI(): OpenAPI? {
        return OpenAPI()
            .info(Info().title("Banking V1 API").version("1.0").description("BANKING API documentation"))
    }
}