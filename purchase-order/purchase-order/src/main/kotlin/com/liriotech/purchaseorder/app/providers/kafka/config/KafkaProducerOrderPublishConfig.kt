package com.liriotech.purchaseorder.app.providers.kafka.config

import io.confluent.kafka.serializers.KafkaAvroSerializer
import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.util.Properties

@Configuration
class KafkaProducerOrderPublishConfig(
    @Value("\${spring.kafka.bootstrap-servers}") private val bootstrapServers: String,
    @Value("\${spring.kafka.properties.schema.registry.url}") private val schemaRegistryUrl: String
) {

    @Bean
    fun producer() : KafkaProducer<String, Any> = KafkaProducer<String, Any>(getProperties())

    fun getProperties() : Properties {
        val props = Properties()
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers)
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer::class.java)
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer::class.java)
        props.put("schema.registry.url", schemaRegistryUrl)
        return props
    }
}