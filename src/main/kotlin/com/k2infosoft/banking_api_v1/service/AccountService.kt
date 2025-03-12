package com.k2infosoft.banking_api_v1.service

import com.k2infosoft.banking_api_v1.dto.AccountsDto

interface AccountService {
    fun createAccount(accountDto: AccountsDto): AccountsDto

    fun getAccountById(id: Long): AccountsDto

    fun deposit(id: Long, amount: Double): AccountsDto

    fun withdraw(id: Long, amount: Double): AccountsDto

    fun getAllAccounts(): List<AccountsDto>

    fun deleteAccount(id: Long)
}