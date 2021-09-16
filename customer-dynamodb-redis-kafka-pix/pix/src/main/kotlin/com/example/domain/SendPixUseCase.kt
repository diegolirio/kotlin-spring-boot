package com.example.domain

import com.example.domain.inputs.SendPixInput
import com.example.domain.outputs.SavePixTransactionOutput
import com.example.domain.outputs.SendPixOutput
import com.example.domain.vo.Transaction
import java.time.LocalDateTime

class SendPixUseCase(
        private val savePixTransactionOutput: SavePixTransactionOutput,
        private val sendPixOutput: SendPixOutput,
) : SendPixInput {

    override fun execute(transaction: Transaction) {
        transaction.dateTimeAt = LocalDateTime.now()
        savePixTransactionOutput.save(transaction).let(sendPixOutput::send)
    }
}