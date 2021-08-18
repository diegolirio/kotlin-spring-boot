package com.example.domain.vo

import java.time.LocalDateTime

data class Transaction(
    var id: String? = null,
    var customerOrigin: String? = null,
    var codePixDestiny: String? = null,
    var dateTimeAt: LocalDateTime? = null,
)