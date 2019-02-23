package com.diegolirio.kotlinmongo.controllers

import com.diegolirio.kotlinmongo.services.product.Product
import com.diegolirio.kotlinmongo.services.product.ProductService
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/v1/products")
class ProductController(private val productService: ProductService) {

    @GetMapping
    fun getAll(): List<Product> = productService.getAll()

    @PostMapping
    fun save(@RequestBody product : Product): Product {
        return productService.save(product)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable("id") id : String) {
        productService.delete(id)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable("id") id : String) : Optional<Product> {
        return productService.getById(id)
    }

}