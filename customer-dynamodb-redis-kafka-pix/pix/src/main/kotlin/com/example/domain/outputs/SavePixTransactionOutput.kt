package com.example.domain.outputs

import com.example.domain.vo.Transaction

interface SavePixTransactionOutput {
    fun save(transaction: Transaction): Transaction
}