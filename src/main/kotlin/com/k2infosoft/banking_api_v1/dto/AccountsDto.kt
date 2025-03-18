package com.k2infosoft.banking_api_v1.dto

import com.k2infosoft.banking_api_v1.entity.Accounts
import io.swagger.v3.oas.annotations.media.Schema
import jakarta.validation.constraints.NotBlank

@Schema(description = "Accounts DTO Model Information")
data class AccountsDto(

 @Schema(description = "account Holder Name Description")
 @get:NotBlank(message = "accountHolderName must not be blank")
 val accountHolderName: String,

 @Schema(description = "balance Description")
 val balance: Double,
){
 fun toEntity(): Accounts = Accounts(accountHolderName = accountHolderName, balance = balance)
}
