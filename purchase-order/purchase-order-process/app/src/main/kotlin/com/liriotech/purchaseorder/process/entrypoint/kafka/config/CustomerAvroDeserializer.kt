package com.liriotech.purchaseorder.process.entrypoint.kafka.config

import io.confluent.kafka.serializers.KafkaAvroDeserializer
import org.apache.avro.Schema
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class CustomerAvroDeserializer : KafkaAvroDeserializer() {

    private val log: Logger = LoggerFactory.getLogger(CustomerAvroDeserializer::class.java)

    override fun deserialize(s: String, bytes: ByteArray): Any {
        return try {
            super.deserialize(s, bytes)
        } catch (e: Exception) {
            log.error("M=deserialize, E=unknown_error, msg=Erro ao deserializar a mensagem, error_msg={}", e.message)
            throw e
        }
    }

    override fun deserialize(s: String, bytes: ByteArray, readerSchema: Schema): Any? {
        return try {
            super.deserialize(s, bytes, readerSchema)
        } catch (e: Exception) {
            log.error("M=deserialize,E=unknown_error, msg=Erro ao deserializar a mensagem, error_msg={}", e.message)
            throw e
        }
    }
}