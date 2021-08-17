package com.example.domain.outputs

import com.example.domain.vo.Transaction

interface SendPixOutput {
    fun execute(transaction: Transaction)
}