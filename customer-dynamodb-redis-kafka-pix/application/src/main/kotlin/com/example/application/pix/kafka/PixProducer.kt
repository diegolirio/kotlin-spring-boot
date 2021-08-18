package com.example.application.pix.kafka

import com.example.domain.outputs.SendPixOutput
import com.example.domain.vo.Transaction
import mu.KLogger
import mu.KotlinLogging
import org.springframework.stereotype.Component

@Component
class PixProducer(
        private val log: KLogger = KotlinLogging.logger {}
) : SendPixOutput {

    override fun send(transaction: Transaction) {
        log.info { transaction }
    }

}