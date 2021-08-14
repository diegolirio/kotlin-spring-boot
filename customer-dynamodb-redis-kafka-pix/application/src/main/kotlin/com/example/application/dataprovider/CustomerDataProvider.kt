package com.example.application.dataprovider

import com.example.application.dataprovider.repository.CustomerRepository
import com.example.domain.outputs.CreateCustomerOutput
import com.example.domain.outputs.FindAllCustomersOutput
import com.example.domain.vo.Customer
import org.springframework.stereotype.Component
import toCustomerEntity
import toCustomerVO
import toCustomersVO

@Component
class CustomerDataProvider(
        private val customerRepository: CustomerRepository
) : FindAllCustomersOutput, CreateCustomerOutput {

    override fun findAll(): List<Customer> = customerRepository.findAll()!!.toCustomersVO()

    override fun create(customer: Customer): Customer {
        return customerRepository.save(customer.toCustomerEntity()).toCustomerVO()
    }
}