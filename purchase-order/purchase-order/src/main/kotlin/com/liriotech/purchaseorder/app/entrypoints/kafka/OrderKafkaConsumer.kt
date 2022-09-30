package com.liriotech.purchaseorder.app.entrypoints.kafka

import com.liriotech.purchaseorder.app.providers.kafka.avro.data.OrderAvro
import io.confluent.kafka.serializers.KafkaAvroDeserializerConfig
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component

@Component
class OrderKafkaConsumer {

    val log = LoggerFactory.getLogger(this::class.java)
    @KafkaListener(
        topics = ["\${spring.kafka.consumer.topics.order.process}"],
        groupId = "\${spring.kafka.consumer.group-id}"
    )
    fun onMessage(message: ConsumerRecord<String, OrderAvro>, ack: Acknowledgment) {
        log.info("message = ${message.value()}")
        ack.acknowledge()
    }

}//