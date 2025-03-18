package com.k2infosoft.banking_api_v1.controller

import com.k2infosoft.banking_api_v1.dto.AccountsDto
import com.k2infosoft.banking_api_v1.service.AccountService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/accounts")
@Tag(name = "Accounts API", description = "Sample API for Banking App")
class AccountsController(private val accountService: AccountService) {

    // Add Account REST API
    @PostMapping
    @Operation(summary = "Accounts Creation Api", description = "Create A New Account")
    @ApiResponse(responseCode = "201", description = "Account Created Successfully")
    fun addAccount(@RequestBody accountDto: AccountsDto): ResponseEntity<AccountsDto> {
        return ResponseEntity<AccountsDto>(accountService.createAccount(accountDto), HttpStatus.CREATED)
    }

    // Get Account REST API
    @GetMapping("/{id}")
    @Operation(summary = "Get Account by Id", description = "Get Existing Account by Id")
    @ApiResponse(responseCode = "200", description = "Account Found Successfully")
    fun getAccountById(@PathVariable id: Long): ResponseEntity<AccountsDto> {
        val accountDto: AccountsDto = accountService.getAccountById(id)
        return ResponseEntity.ok<AccountsDto>(accountDto)
    }

    // Deposit REST API
    @PutMapping("/{id}/deposit")
    @Operation(summary = "Deposit Rest Api", description = "Deposit on Existing Account by Id")
    @ApiResponse(responseCode = "200", description = "Amount Deposited Successfully")
    fun deposit(
        @PathVariable id: Long,
        @RequestBody request: MutableMap<String, Double>
    ): ResponseEntity<AccountsDto> {
        val amount: Double = request["amount"]!!
        val accountDto: AccountsDto = accountService.deposit(id, amount)
        return ResponseEntity.ok<AccountsDto>(accountDto)
    }

    // Withdraw REST API
    @PutMapping("/{id}/withdraw")
    @Operation(summary = "Withdraw Rest Api", description = "Withdraw on Existing Account by Id")
    @ApiResponse(responseCode = "200", description = "Amount Withdraw Successfully")
    fun withdraw(
        @PathVariable id: Long,
        @RequestBody request: MutableMap<String, Double>
    ): ResponseEntity<AccountsDto> {
        val amount: Double = request["amount"]!!
        val accountDto: AccountsDto = accountService.withdraw(id, amount)
        return ResponseEntity.ok<AccountsDto>(accountDto)
    }

    // Get All Accounts REST API
    @GetMapping
    @Operation(summary = "Get All Accounts Rest Api", description = "Get All accounts")
    @ApiResponse(responseCode = "200", description = "Accounts Found Successfully")
    fun getAllAccounts(): ResponseEntity<List<AccountsDto>> {
        val accounts: List<AccountsDto> = accountService.getAllAccounts()
        return ResponseEntity.ok<List<AccountsDto>>(accounts)
    }

    // Delete Account REST API
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Account Rest Api", description = "Delete on Existing Account by Id")
    @ApiResponse(responseCode = "200", description = "Account Deleted Successfully")
    fun deleteAccount(@PathVariable id: Long): ResponseEntity<String> {
        accountService.deleteAccount(id)
        return ResponseEntity.ok<String>("Account is deleted successfully!")
    }

}