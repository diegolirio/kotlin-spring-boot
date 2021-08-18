package com.example.domain.outputs

import com.example.domain.vo.Transaction

interface SendPixOutput {
    fun send(transaction: Transaction)
}