package com.example.bankapi

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AccountRepository : CrudRepository<Account, String> {

    fun findByDocument(document: String): Optional<Account>
}