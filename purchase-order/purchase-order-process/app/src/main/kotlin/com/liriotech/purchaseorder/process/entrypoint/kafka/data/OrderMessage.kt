package com.liriotech.purchaseorder.process.entrypoint.kafka.data

import com.liriotech.purchaseorder.process.entities.OrderEntity
import kotlinx.serialization.Contextual
import kotlinx.serialization.Serializable
import java.math.BigDecimal
import java.time.LocalDateTime

@Serializable
data class OrderMessage(
    val id: String? = null,
    val productCode: String? = null,
    val customerId: String? = null,
    @Contextual val value: BigDecimal? = null,
    val status: StatusEnum? = null,
    @Contextual val date: LocalDateTime? = null
)

enum class StatusEnum {
    PENDING,
    PROCESSING,
    SCHEDULED,
    DONE,
    ERROR
}

fun OrderMessage.toEntity(): OrderEntity =
    OrderEntity(
        id = this.id,
        productCode = this.productCode,
        customerId = this.customerId,
        value = this.value,
        status = com.liriotech.purchaseorder.process.entities.StatusEnum.valueOf(this.status.toString())
    )
