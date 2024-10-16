package com.example.audited_table.repository

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import org.hibernate.envers.AuditTable
import org.hibernate.envers.Audited
import java.time.OffsetDateTime
import java.util.UUID

@Entity(name = "account")
@Audited
@AuditTable(value = "account_audit")
data class AccountEntity(
    @Id
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val company: String,
    @Column(name = "groups")
    val groups: String,
    val email: String,
    @Column(name = "email_sent")
    val emailSent: Boolean,
    val phone: String,
    val status: String,
    @Column(name = "created_at")
    val createdAt: OffsetDateTime,
    @Column(name = "updated_at")
    val updatedAt: OffsetDateTime? = null,
)
