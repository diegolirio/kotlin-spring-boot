package com.liriotech.purchaseorder.process.entrypoint.kafka.config

import com.github.avrokotlin.avro4k.Avro
import com.github.avrokotlin.avro4k.serializer.BigDecimalSerializer
import com.github.avrokotlin.avro4k.serializer.LocalDateSerializer
import com.github.avrokotlin.avro4k.serializer.LocalDateTimeSerializer
import com.github.avrokotlin.avro4k.serializer.UUIDSerializer
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AvroConfig {

    @Bean("avro")
    open fun avro(): Avro {
        return Avro(
            SerializersModule {
                contextual(UUIDSerializer())
                contextual(BigDecimalSerializer())
                contextual(LocalDateSerializer())
                contextual(LocalDateTimeSerializer())
            }
        )
    }
}
