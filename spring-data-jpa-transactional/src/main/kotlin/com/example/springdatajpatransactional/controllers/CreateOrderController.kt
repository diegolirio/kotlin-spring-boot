package com.example.springdatajpatransactional.controllers

import com.example.springdatajpatransactional.controllers.data.OrderRequest
import com.example.springdatajpatransactional.controllers.data.ResponseID
import com.example.springdatajpatransactional.services.OrderService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/orders")
class CreateOrderController(
    private val orderService: OrderService
) {

    @PostMapping
    fun create(@RequestBody orderRequest: OrderRequest) : ResponseID = orderService.create(orderRequest)

}