package com.example.bankapi

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/accounts")
class AccountController(val accountRepository: AccountRepository) {

    @PostMapping
    fun save(@RequestBody account: Account) = ResponseEntity.ok(accountRepository.save(account))

    @GetMapping
    fun getAll() = ResponseEntity.ok(accountRepository.findAll())

    @GetMapping("/{documenet}")
    fun getByDocument(@PathVariable document: String) = ResponseEntity.ok(accountRepository.findByDocument(document))

    @PutMapping("/{documenet}")
    fun update(@PathVariable document: String, @RequestBody account: Account): ResponseEntity<Account> {
        val findByDocument = this.accountRepository.findByDocument(document)
        val accountToSave = findByDocument.orElseThrow { RuntimeException("Account document: $document not found") }
                .copy(name = account.name, balance = account.balance)
        return ResponseEntity.ok(accountRepository.save(accountToSave))
    }

    @DeleteMapping("/{documenet}")
    fun deleteByDocument(@PathVariable document: String) = accountRepository.findByDocument(document)
            .ifPresent { accountRepository.delete(it) }



}