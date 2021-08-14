package com.example.domain

interface DeleteCustomerUseCase {
    fun execute(id: String): Unit
}
