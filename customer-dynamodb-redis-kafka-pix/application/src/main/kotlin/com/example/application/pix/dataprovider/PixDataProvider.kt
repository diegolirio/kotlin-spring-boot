package com.example.application.pix.dataprovider

import com.example.domain.outputs.SendPixOutput
import com.example.domain.vo.Transaction
import org.springframework.stereotype.Component

@Component
class PixDataProvider : SendPixOutput {

    override fun execute(transaction: Transaction) {

    }

}