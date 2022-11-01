package com.example.demoreadfile


import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class LayoutClient(
    private val restTemplate: RestTemplate
) {

    fun get(resourceId: Long): FileData? =
        restTemplate
            .getForObject("http://localhost:8080/resource/${resourceId}/data", FileData::class.java)

}