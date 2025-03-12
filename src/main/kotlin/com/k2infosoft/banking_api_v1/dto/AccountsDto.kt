package com.k2infosoft.banking_api_v1.dto

import com.k2infosoft.banking_api_v1.entity.Accounts
import jakarta.validation.constraints.NotBlank

data class AccountsDto(
 @get:NotBlank(message = "accountHolderName must not be blank")
 val accountHolderName: String,
 val balance: Double,
){
 fun toEntity(): Accounts = Accounts(accountHolderName = accountHolderName, balance = balance)
}
