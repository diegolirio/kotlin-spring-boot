package com.example.application.pix.shared.dto

data class TransactionRequest(
        var id: String? = null,
        var customerOrigin: String? = null,
        var customerDestiny: String? = null,
)