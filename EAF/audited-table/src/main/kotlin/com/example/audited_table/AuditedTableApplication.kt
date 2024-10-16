package com.example.audited_table

import com.example.audited_table.repository.AccountEntity
import com.example.audited_table.repository.AccountRepository
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import java.time.OffsetDateTime
import java.util.UUID

@SpringBootApplication
class AuditedTableApplication

fun main(args: Array<String>) {
    runApplication<AuditedTableApplication>(*args)
}

@Component
class Runner(
    private val repository: AccountRepository,
) : CommandLineRunner {
    override fun run(vararg args: String?) {
        val entity =
            AccountEntity(
                id = UUID.randomUUID(),
                status = "PENDING",
                name = "Diego",
                email = "d@d.com",
                phone = "1111111111",
                createdAt = OffsetDateTime.now(),
                emailSent = false,
                updatedAt = OffsetDateTime.now(),
                groups = "NULL",
                company = "Barcelona",
            )
        repository.save(entity)

        println(repository.findById(entity.id))

        val entityUpdated = entity.copy(status = "APPROVED", updatedAt = OffsetDateTime.now(), emailSent = true)
        repository.save(entityUpdated)

        println(repository.findById(entity.id))
    }
}
