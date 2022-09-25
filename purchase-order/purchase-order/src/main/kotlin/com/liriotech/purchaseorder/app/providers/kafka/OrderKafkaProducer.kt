package com.liriotech.purchaseorder.app.providers.kafka

import com.liriotech.purchaseorder.app.providers.kafka.extensions.toAvro
import com.liriotech.purchaseorder.domain.entities.OrderEntity
import com.liriotech.purchaseorder.domain.providers.NotifyChangesProvider
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component


@Component
class OrderKafkaProducer(
    @Value("\${topic.name.producer}") private val topicName: String,
    private val producer: KafkaProducer<String, Any>
) : NotifyChangesProvider {

    private val log = LoggerFactory.getLogger(this::class.java)

    override fun send(orderEntity: OrderEntity): Boolean =
        producer
            .send(
                ProducerRecord(topicName, orderEntity.toAvro())
            ).let {
                log.info(
                    "m=send; event=OrderPublish; msg={}; customerId=${orderEntity.customerId};  topic=${topicName}; payload=$it ",
                    "Mensagem enviada com sucesso"
                )
                return true
            }

}