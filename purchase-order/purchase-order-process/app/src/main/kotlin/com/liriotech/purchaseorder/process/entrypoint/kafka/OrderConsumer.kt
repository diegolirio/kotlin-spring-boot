package com.liriotech.purchaseorder.process.entrypoint.kafka

import com.github.avrokotlin.avro4k.Avro
import com.liriotech.purchaseorder.process.entrypoint.kafka.data.OrderMessage
import com.liriotech.purchaseorder.process.entrypoint.kafka.data.toEntity
import com.liriotech.purchaseorder.process.usecases.CreateOrderProcessUsecase
import org.apache.avro.generic.GenericRecord
import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.kafka.support.Acknowledgment
import org.springframework.stereotype.Component

@Component
class OrderConsumer(
    private val avro: Avro,
    private val createOrderProcessUsecase: CreateOrderProcessUsecase
) {

    @KafkaListener(
        topics = ["\${spring.kafka.consumer.topics.order}"],
        groupId = "\${spring.kafka.consumer.group-id}"
    )
    fun onMessage(
        message: ConsumerRecord<String, GenericRecord>,
        ack: Acknowledgment
    ) {
        val orderMessage = avro.fromRecord(OrderMessage.serializer(), message.value())
        createOrderProcessUsecase.create(orderMessage.toEntity())
        ack.acknowledge()
    }
}
