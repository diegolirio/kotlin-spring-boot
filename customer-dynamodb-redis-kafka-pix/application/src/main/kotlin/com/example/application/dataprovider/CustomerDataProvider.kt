package com.example.application.dataprovider

import com.example.application.dataprovider.repository.CustomerRepository
import com.example.domain.outputs.*
import com.example.domain.vo.Customer
import org.springframework.stereotype.Component
import toCustomerEntity
import toCustomerVO
import toCustomersVO

@Component
class CustomerDataProvider(
        private val customerRepository: CustomerRepository
) : FindAllCustomersOutput, FindCustomerByIdOutput, CreateCustomerOutput, UpdateCustomerOutput, DeleteCustomerOutput {

    override fun findAll(): List<Customer> = customerRepository.findAll()!!.toCustomersVO()

    override fun create(customer: Customer): Customer {
        return customerRepository.save(customer.toCustomerEntity()).toCustomerVO()
    }

    override fun findById(id: String): Customer {
        return customerRepository.findById(id).toCustomerVO()
    }

    override fun update(customer: Customer): Customer {
        return customerRepository.save(customer.toCustomerEntity()).toCustomerVO()
    }

    override fun deleteById(customer: Customer) {
        customerRepository.delete(customer.toCustomerEntity())
    }
}