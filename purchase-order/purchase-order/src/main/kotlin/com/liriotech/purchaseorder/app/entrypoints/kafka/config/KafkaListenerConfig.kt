package com.liriotech.purchaseorder.app.entrypoints.kafka.config

import org.springframework.boot.autoconfigure.kafka.KafkaProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.config.KafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer
import org.springframework.kafka.listener.ContainerProperties.AckMode


@Configuration
class KafkaListenerConfig(
    private val properties: KafkaProperties
) {

    @Bean
    fun consumerFactory(): ConsumerFactory<String, String> {
        return DefaultKafkaConsumerFactory(
            properties.buildConsumerProperties()
        )
    }

    @Bean
    fun kafkaListenerContainerFactory(): KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String, String>> {
        val listener = ConcurrentKafkaListenerContainerFactory<String, String>()
        listener.consumerFactory = consumerFactory()
        listener.containerProperties.isMissingTopicsFatal =
            false // Não falhar, caso ainda não existam os tópicos para consumo
        listener.containerProperties.ackMode = AckMode.MANUAL
        listener.containerProperties.isSyncCommits = true
        return listener
    }
}