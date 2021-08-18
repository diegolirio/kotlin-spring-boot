package com.example.domain.inputs

import com.example.domain.SendPixUseCase
import com.example.domain.outputs.SavePixTransactionOutput
import com.example.domain.outputs.SendPixOutput
import com.example.domain.vo.Transaction
import java.time.LocalDateTime

class SendPixInput(
        private val savePixTransactionOutput: SavePixTransactionOutput,
        private val sendPixOutput: SendPixOutput,
) : SendPixUseCase {

    override fun execute(transaction: Transaction) {
        transaction.dateTimeAt = LocalDateTime.now()
        savePixTransactionOutput.save(transaction).let(sendPixOutput::send)
    }
}