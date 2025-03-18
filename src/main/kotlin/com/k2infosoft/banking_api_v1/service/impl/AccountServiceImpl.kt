package com.k2infosoft.banking_api_v1.service.impl

import com.k2infosoft.banking_api_v1.dto.AccountsDto
import com.k2infosoft.banking_api_v1.entity.Accounts
import com.k2infosoft.banking_api_v1.repository.AccountsRepository
import com.k2infosoft.banking_api_v1.service.AccountService
import jakarta.transaction.Transactional
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service

class AccountServiceImpl(private val accountsRepository: AccountsRepository): AccountService {
    companion object {
        val logger: Logger = LoggerFactory.getLogger(AccountServiceImpl::class.java)
    }

    @Transactional
    override fun createAccount(accountDto: AccountsDto): AccountsDto {
       val accountEntity = accountDto.toEntity()
        return accountsRepository.save<Accounts>(accountEntity).toDto()
    }
    @Transactional
    override fun getAccountById(id: Long): AccountsDto {
        logger.info("Getting account by id $id")
      return accountsRepository.findById(id).get().toDto()
    }
    @Transactional
    override fun deposit(id: Long, amount: Double): AccountsDto {
        val account: Accounts? = accountsRepository
            .findById(id)
            .orElseThrow({ RuntimeException("Account does not exists") })
        val total = account!!.balance + amount
        account.balance = total
        logger.info("Depositing amount $amount")
        return accountsRepository.save(account).toDto()
    }
    @Transactional
    override fun withdraw(id: Long, amount: Double): AccountsDto {
        val account: Accounts? = accountsRepository
            .findById(id)
            .orElseThrow({ RuntimeException("Account does not exists") })
        logger.info("Withdrawing amount $amount")
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
        logger.info("Deleting account by id $id")
        return accountsRepository.deleteById(id)
    }
}