package com.example.application.dataprovider

import com.example.application.dataprovider.repository.CustomerRepository
import com.example.domain.outputs.FindAllCustomersOutput
import com.example.domain.vo.Customer
import org.springframework.stereotype.Component
import toCustomersVO

@Component
class CustomerDataProvider(
        private val customerRepository: CustomerRepository
) : FindAllCustomersOutput {

    override fun findAll(): List<Customer> = customerRepository.findAll()!!.toCustomersVO()
}