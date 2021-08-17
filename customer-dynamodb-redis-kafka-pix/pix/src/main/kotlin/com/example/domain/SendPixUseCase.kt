package com.example.domain

import com.example.domain.vo.Transaction

interface SendPixUseCase {
    fun execute(transaction: Transaction): Unit
}