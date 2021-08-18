package com.example.application.configuration.usecase

import com.example.application.customer.dataprovider.CustomerDataProvider
import com.example.application.pix.dataprovider.PixDataProvider
import com.example.application.pix.kafka.PixProducer
import com.example.domain.*
import com.example.domain.inputs.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseBeans(
        private val customerDataProvider: CustomerDataProvider,
        private val pixDataProvider: PixDataProvider,
        private val pixProducer : PixProducer,
) {

    @Bean fun createCustomerUseCase() : CreateCustomerUseCase = CreateCustomerInput(customerDataProvider)
    @Bean fun updateCustomerUseCase() : UpdateCustomerUseCase = UpdateCustomerInput(customerDataProvider, customerDataProvider)
    @Bean fun deleteCustomerUseCase() : DeleteCustomerUseCase = DeleteCustomerInput(customerDataProvider, customerDataProvider)
    @Bean fun findAllCustomersUseCase() : FindAllCustomersUseCase = FindAllCustomersInput(customerDataProvider)
    @Bean fun findCustomerByIdUseCase() : FindCustomerByIdUseCase = FindCustomerByIdInput(customerDataProvider)

    @Bean fun sendPixUseCase() : SendPixUseCase = SendPixInput(pixDataProvider, pixProducer)
}