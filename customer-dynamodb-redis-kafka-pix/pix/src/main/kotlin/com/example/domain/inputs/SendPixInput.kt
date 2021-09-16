package com.example.domain.inputs

import com.example.domain.vo.Transaction

interface SendPixInput {

    fun execute(transaction: Transaction)
}