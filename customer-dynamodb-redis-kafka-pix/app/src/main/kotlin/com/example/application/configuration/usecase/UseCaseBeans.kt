package com.example.application.configuration.usecase

import com.example.domain.CreateCustomerUseCase
import com.example.domain.inputs.CreateCustomerInput
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UseCaseBeans {

    @Bean
    fun createCustomerInput() : CreateCustomerUseCase = CreateCustomerInput()
}