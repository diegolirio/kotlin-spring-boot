package com.example.springdatajpatransactional.services

import com.example.springdatajpatransactional.controllers.data.OrderRequest
import com.example.springdatajpatransactional.controllers.data.ResponseID
import com.example.springdatajpatransactional.models.OrderModel
import com.example.springdatajpatransactional.models.OrderProductModel
import com.example.springdatajpatransactional.repositories.AddressRepository
import com.example.springdatajpatransactional.repositories.CustomerRepository
import com.example.springdatajpatransactional.repositories.OrderProductRepository
import com.example.springdatajpatransactional.repositories.OrderRepository
import com.example.springdatajpatransactional.repositories.ProductRepository
import com.example.springdatajpatransactional.toModel
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal

@Service
@Transactional
class OrderService(
    private val customerRepository: CustomerRepository,
    private val addressRepository: AddressRepository,
    private val productRepository: ProductRepository,
    private val orderRepository: OrderRepository,
    private val orderProductRepository: OrderProductRepository
) {

    fun create(orderRequest: OrderRequest): ResponseID {

        var customer =
            orderRequest
                .customer
                .toModel()
                .let {
                    if(it.id == null) customerRepository.save(it) else it
                }

        orderRequest
            .customer
            .address
            .toModel()
            .let {
                if(it.id == null) addressRepository.save(it)
            }

        val products =
            orderRequest.items
                .map {
                    it.product.toModel(it.price)
                }
                .map {
                    if(it.id == null) productRepository.save(it) else it
                }

        val order =
            OrderModel(
                customer = customer,
                total = orderRequest.items.map { it.price.multiply(BigDecimal(it.amount)) }.sumOf { it }
            ).let {
                orderRepository.save(it)
            }

        if(customer.cpfCnpj == "35357659860") {
            throw RuntimeException("CPF/CNPJ invalido!")
        }

        orderRequest.items
            .map { items ->
                products.map {
                    OrderProductModel(
                        id = null,
                        productModel = it,
                        price = it.price,
                        amount = items.amount,
                        orderModel = order
                )
            }
        }
        .map(orderProductRepository::saveAll)

        return ResponseID(id = order.id!!)
    }

}
