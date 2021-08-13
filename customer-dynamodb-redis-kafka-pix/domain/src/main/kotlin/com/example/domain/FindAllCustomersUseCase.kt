package com.example.domain

import com.example.domain.vo.Customer

interface FindAllCustomersUseCase {
    fun execute(): List<Customer>
}