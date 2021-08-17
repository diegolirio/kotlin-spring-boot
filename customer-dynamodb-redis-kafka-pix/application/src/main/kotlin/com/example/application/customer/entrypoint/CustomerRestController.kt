package com.example.application.customer.entrypoint

import com.example.application.configuration.cache.RedisConfig
import com.example.application.customer.dto.CustomerRequest
import com.example.application.customer.dto.CustomerResponse
import com.example.domain.*
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.web.bind.annotation.*
import toCustomerResponse
import toCustomerVO
import toCustomersResponse

@RestController
@RequestMapping("/customers")
class CustomerRestController(
        private val findAllCustomersUseCase: FindAllCustomersUseCase,
        private val findByIdCustomerUseCase: FindCustomerByIdUseCase,
        private val createCustomerUseCase: CreateCustomerUseCase,
        private val updateCustomerUseCase: UpdateCustomerUseCase,
        private val deleteCustomerUseCase: DeleteCustomerUseCase,
) {

    @GetMapping
    @Cacheable(RedisConfig.CUSTOMERS_CACHE)
    fun getList(): List<CustomerResponse> {
        return findAllCustomersUseCase.execute().toCustomersResponse()
    }

    @GetMapping("/{id}")
    @Cacheable(RedisConfig.CUSTOMERS_BY_ID_CACHE)
    fun getById(@PathVariable id: String): CustomerResponse {
        return findByIdCustomerUseCase.execute(id).toCustomerResponse()
    }

    @PostMapping
    @CacheEvict(cacheNames = [
        RedisConfig.CUSTOMERS_CACHE,
        RedisConfig.CUSTOMERS_BY_ID_CACHE], allEntries = true)
    fun create(@RequestBody customerRequest: CustomerRequest): CustomerResponse {
        return createCustomerUseCase.execute(customerRequest.toCustomerVO()).toCustomerResponse()
    }

    @PutMapping("/{id}")
    @CacheEvict(cacheNames = [
        RedisConfig.CUSTOMERS_CACHE,
        RedisConfig.CUSTOMERS_BY_ID_CACHE], allEntries = true)
    fun update(@PathVariable id: String, @RequestBody customerRequest: CustomerRequest): CustomerResponse {
        return updateCustomerUseCase.execute(id, customerRequest.toCustomerVO()).toCustomerResponse()
    }

    @DeleteMapping("/{id}")
    @CacheEvict(cacheNames = [
        RedisConfig.CUSTOMERS_CACHE,
        RedisConfig.CUSTOMERS_BY_ID_CACHE], allEntries = true)
    fun delete(@PathVariable id: String) {
        deleteCustomerUseCase.execute(id)
    }
}