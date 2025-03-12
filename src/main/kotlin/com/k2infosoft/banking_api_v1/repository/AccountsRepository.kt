package com.k2infosoft.banking_api_v1.repository

import com.k2infosoft.banking_api_v1.entity.Accounts
import org.springframework.data.jpa.repository.JpaRepository

interface AccountsRepository: JpaRepository<Accounts, Long>