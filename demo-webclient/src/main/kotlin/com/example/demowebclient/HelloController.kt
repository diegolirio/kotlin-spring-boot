package com.example.demowebclient

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient


@RestController
@RequestMapping
class HelloController(
    private val webClientBuilder: WebClient.Builder,
    @Value("\${providers.service.product.host}") private val hostService: String
) {

    @GetMapping("/hello")
    fun hello(name: String?): String {
        //provider()
        return if(name == null) "Hello, world!" else "Hello, $name!"
    }

    @GetMapping("/hi/{name}")
    fun hello(@PathVariable("name") name: String): String {
        return "Hello, $name!"
    }

//    fun provider() {
//        webClientBuilder
//            .baseUrl("$hostService/customer/api/v1/products")
//            .build()
//            .get()
//            .retrieve()
//            .bodyToMono(String.class)
//            .subscribe()
//    }


}