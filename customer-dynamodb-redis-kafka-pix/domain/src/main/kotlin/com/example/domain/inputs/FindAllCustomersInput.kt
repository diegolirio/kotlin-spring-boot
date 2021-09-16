package com.example.domain.inputs

import com.example.domain.Customer

interface FindAllCustomersInput {

    fun execute(): List<Customer>

}