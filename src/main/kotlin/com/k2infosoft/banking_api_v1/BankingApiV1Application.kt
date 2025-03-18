package com.k2infosoft.banking_api_v1

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
