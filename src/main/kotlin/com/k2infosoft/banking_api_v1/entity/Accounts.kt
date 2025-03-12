package com.k2infosoft.banking_api_v1.entity

import com.k2infosoft.banking_api_v1.dto.AccountsDto
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
data class Accounts(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    val accountHolderName: String,
    var balance: Double,
    val createdDate: String = LocalDateTime.now().toString(),
    val updatedDate: String = LocalDateTime.now().toString()
){
    fun toDto(): AccountsDto = AccountsDto(accountHolderName,balance)
}
