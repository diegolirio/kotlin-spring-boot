package com.example.testcontainer.app.listener

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import java.util.concurrent.CountDownLatch

@Component
class CustodyPricedListener {

    private val log = LoggerFactory.getLogger(javaClass)

    private var latch = CountDownLatch(1)
    private var payload: String? = null

    @KafkaListener(topics = ["\${test.topic}"])
    fun listener(consumerRecord: ConsumerRecord<*, *>) {
        log.info("m=listener, payload='{}'", consumerRecord.toString())

        payload = consumerRecord.toString()
        latch.countDown()
    }

    fun getLatch(): CountDownLatch {
        return latch
    }

    fun resetLatch() {
        latch = CountDownLatch(1)
    }

    fun getPayload(): String? {
        return payload
    }

}

