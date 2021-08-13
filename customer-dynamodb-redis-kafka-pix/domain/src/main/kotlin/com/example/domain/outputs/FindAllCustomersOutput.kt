package com.example.domain.outputs

import com.example.domain.vo.Customer

interface FindAllCustomersOutput {
    fun findAll(): List<Customer>
}