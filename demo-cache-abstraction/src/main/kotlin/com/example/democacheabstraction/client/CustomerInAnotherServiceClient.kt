package com.example.democacheabstraction.client

import com.example.democacheabstraction.entity.Customer
import org.apache.juli.logging.LogFactory
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Component
import java.util.*

@Component
class CustomerInAnotherServiceClient(
    private val loginClient: LoginClient
) {

    private val log = LogFactory.getLog(javaClass)

    @Cacheable("customers")
    fun getCustomer(id: String) : Customer {
        val token = loginClient.login(clientId = "diego", clientSecret = "lirio")
        log.info("token = $token")
        return Customer(UUID.randomUUID().toString(), "Jessica", 29)
    }


}