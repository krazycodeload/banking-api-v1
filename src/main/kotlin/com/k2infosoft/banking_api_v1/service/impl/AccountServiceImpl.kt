package com.k2infosoft.banking_api_v1.service.impl

import com.k2infosoft.banking_api_v1.dto.AccountsDto
import com.k2infosoft.banking_api_v1.entity.Accounts
import com.k2infosoft.banking_api_v1.repository.AccountsRepository
import com.k2infosoft.banking_api_v1.service.AccountService
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class AccountServiceImpl(private val accountsRepository: AccountsRepository): AccountService {

    @Transactional
    override fun createAccount(accountDto: AccountsDto): AccountsDto {
       val accountEntity = accountDto.toEntity()
        return accountsRepository.save<Accounts>(accountEntity).toDto()
    }
    @Transactional
    override fun getAccountById(id: Long): AccountsDto {
      return accountsRepository.findById(id).get().toDto()
    }
    @Transactional
    override fun deposit(id: Long, amount: Double): AccountsDto {
        val account: Accounts? = accountsRepository
            .findById(id)
            .orElseThrow({ RuntimeException("Account does not exists") })
        val total = account!!.balance + amount
        account.balance = total
        return accountsRepository.save(account).toDto()
    }
    @Transactional
    override fun withdraw(id: Long, amount: Double): AccountsDto {
        val account: Accounts? = accountsRepository
            .findById(id)
            .orElseThrow({ RuntimeException("Account does not exists") })
        if (account!!.balance < amount) {
            throw java.lang.RuntimeException("Insufficient amount")
        }

        val total = account.balance - amount
        account.balance = total
        return accountsRepository.save(account).toDto()
    }
    @Transactional
    override fun getAllAccounts(): List<AccountsDto> {
        return accountsRepository.findAll().map { it.toDto() }
    }

    @Transactional
    override fun deleteAccount(id: Long) {
        val account: Accounts? = accountsRepository
            .findById(id)
            .orElseThrow({ java.lang.RuntimeException("Account does not exists") })
        return accountsRepository.deleteById(id)
    }
}