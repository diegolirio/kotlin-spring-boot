package com.example.domain.outputs

import com.example.domain.Customer

interface FindAllCustomersOutput {
    fun findAll(): List<Customer>
}