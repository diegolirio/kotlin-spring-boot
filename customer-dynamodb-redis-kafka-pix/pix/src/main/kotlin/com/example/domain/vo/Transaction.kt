package com.example.domain.vo

data class Transaction(
    var id: String? = null,
    var customerOrigin: String? = null,
    var customerDestiny: String? = null,
    var dateTimeAt: String? = null,
)