package com.example.domain

import com.example.domain.Customer

interface FindAllCustomersUseCase {
    fun execute(): List<Customer>
}