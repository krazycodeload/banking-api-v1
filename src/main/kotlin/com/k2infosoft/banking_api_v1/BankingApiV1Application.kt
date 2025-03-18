package com.k2infosoft.banking_api_v1

import io.swagger.v3.oas.annotations.ExternalDocumentation
import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.info.License
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
//@OpenAPIDefinition(
//	info = @Info(
//		title = "Banking API",
//		description = "API for Banking App",
//		version = "1.0",
//		contact = @Contact(
//			name = "K2infosoft",
//			email = "OQ0v6@example.com"
//		)
//	)
//
//)
class BankingApiV1Application

fun main(args: Array<String>) {
	runApplication<BankingApiV1Application>(*args)
}
