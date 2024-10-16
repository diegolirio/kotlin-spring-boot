package com.example.flyway.routes

import io.r2dbc.spi.Row
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.router
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.scheduler.Schedulers
import java.math.BigDecimal

@Configuration
class ProductRoute(
    private val productHandler: ProductHandler
) {

    companion object { const val ROOT = "" }

    @Bean
    fun routePosition() = router {
        (ProductHandler.PATH and accept(MediaType.APPLICATION_JSON)).nest {
            GET(ROOT, productHandler::get)
        }
    }

}

@Component
class ProductHandler(
    private val productUseCase : ProductUseCase
) {

    companion object {
        const val PATH = "/products"
    }

    fun get(serverRequest: ServerRequest): Mono<ServerResponse> =
        ServerResponse
            .ok()
            .body(productUseCase.get(), ProductEntity::class.java)

}

data class ProductEntity(
    val id: Long,
    val name: String,
    val price: BigDecimal,
)

@Service
class ProductUseCase(
    private val productDataProvider: ProductDataProvider
) {

    fun get(): Flux<ProductEntity> {
        return productDataProvider.getAll()
    }

}

@Repository
class ProductDataProvider(
    private val template: R2dbcEntityTemplate,
) {

    fun getAll(): Flux<ProductEntity> {
        return template.databaseClient.sql(
            """  SELECT * FROM product """
        )
        .map { row, _ -> toEntity(row) }
        .all() // .first()
        .publishOn(Schedulers.boundedElastic())
    }

    private fun toEntity(row: Row?) =
        ProductEntity(
            id = (row?.get("id") as Int).toLong(),
            name = row["nome"] as String,
            price = row["valor"] as BigDecimal,
        )
}
