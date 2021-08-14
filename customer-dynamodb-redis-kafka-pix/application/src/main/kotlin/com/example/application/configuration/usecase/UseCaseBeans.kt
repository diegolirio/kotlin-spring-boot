package com.example.application.configuration.usecase

import com.example.application.dataprovider.CustomerDataProvider
import com.example.domain.CreateCustomerUseCase
import com.example.domain.FindAllCustomersUseCase
import com.example.domain.inputs.CreateCustomerInput
import com.example.domain.inputs.FindAllCustomersInput
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseBeans(
        private val customerDataProvider: CustomerDataProvider
) {

    @Bean
    fun createCustomerUseCase() : CreateCustomerUseCase = CreateCustomerInput(customerDataProvider)

    @Bean
    fun findAllCustomersUseCase() : FindAllCustomersUseCase = FindAllCustomersInput(customerDataProvider)
}