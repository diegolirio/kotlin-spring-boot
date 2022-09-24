package com.liriotech.purchaseorder.app.providers.kafka

import com.liriotech.purchaseorder.app.providers.kafka.avro.data.OrderAvro
import com.liriotech.purchaseorder.app.providers.kafka.extensions.toAvro
import com.liriotech.purchaseorder.domain.entities.OrderEntity
import com.liriotech.purchaseorder.domain.providers.NotifyChangesProvider
import org.apache.kafka.clients.producer.ProducerRecord
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component

@Component
class OrderKafkaProducer(
    @Value("\${topic.name.producer}") private val topicName: String,
    private val kafkaTemplate: KafkaTemplate<String, OrderAvro>
) : NotifyChangesProvider {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun send(orderEntity: OrderEntity): Boolean =
        kafkaTemplate
            .send(ProducerRecord(topicName, orderEntity.toAvro()))
            .addCallback(
                {
                    log.info(
                        "m=send; event=OrderPublish; msg={}; customerId=${orderEntity.customerId};  topic=${topicName}; payload=${it.toString()};",
                        "Mensagem enviada com sucesso"
                    )
                },
                {
                    log.error(
                        "m=send; event=OrderPublish; msg={}; customerId=${orderEntity.customerId};  topic=${topicName}; payload=${it.toString()}",
                        "Mensagem não enviada"
                    )
                })
                .let { true }
}