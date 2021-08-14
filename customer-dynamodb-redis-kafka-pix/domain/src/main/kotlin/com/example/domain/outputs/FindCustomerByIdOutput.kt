package com.example.domain.outputs

import com.example.domain.vo.Customer

interface FindCustomerByIdOutput {
    fun findById(id: String): Customer
}
