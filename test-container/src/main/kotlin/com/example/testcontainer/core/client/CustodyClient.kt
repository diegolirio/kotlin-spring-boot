package com.example.testcontainer.core.client

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Component

@Component
class CustodyClient(
    private val restTemplateBuilder: RestTemplateBuilder,
    @Value("\${http.clients.corf-custody-host}")
    private val url: String
) {
    private val log = LoggerFactory.getLogger(javaClass)

    fun getCustody(code: String): CustodyResponse {
        log.info("m=getCustody, stage=init, code=$code")
        return restTemplateBuilder.build()
            .getForObject(
                "$url/v2/custody/$code",
                CustodyResponse::class.java
            )!!.also {
                log.info("m=getCustody, stage=init, code=$code, response=$it")
            }
    }
}
