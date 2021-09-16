package com.example.application.configuration.ports

import com.example.application.customer.out.dataprovider.CustomerDataProvider
import com.example.application.pix.out.dataprovider.PixDataProvider
import com.example.application.pix.out.kafka.PixProducer
import com.example.domain.*
import com.example.domain.inputs.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InputPortBeans(
        private val customerDataProvider: CustomerDataProvider,
        private val pixDataProvider: PixDataProvider,
        private val pixProducer : PixProducer,
) {

    @Bean fun createCustomerUseCase() : CreateCustomerInput = CreateCustomerUseCase(customerDataProvider)
    @Bean fun updateCustomerUseCase() : UpdateCustomerInput = UpdateCustomerUseCase(customerDataProvider, customerDataProvider)
    @Bean fun deleteCustomerUseCase() : DeleteCustomerInput = DeleteCustomerUseCase(customerDataProvider, customerDataProvider)
    @Bean fun findAllCustomersUseCase() : FindAllCustomersInput = FindAllCustomersUseCase(customerDataProvider)
    @Bean fun findCustomerByIdUseCase() : FindCustomerByIdInput = FindCustomerByIdUseCase(customerDataProvider)

    @Bean fun sendPixUseCase() : SendPixInput = SendPixUseCase(pixDataProvider, pixProducer)
}