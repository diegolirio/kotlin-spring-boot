package com.example.application.pix.out.dataprovider

import com.example.domain.outputs.SavePixTransactionOutput
import com.example.domain.vo.Transaction
import org.springframework.stereotype.Component

@Component
class PixDataProvider : SavePixTransactionOutput {

    override fun save(transaction: Transaction): Transaction {
        return transaction
    }

}