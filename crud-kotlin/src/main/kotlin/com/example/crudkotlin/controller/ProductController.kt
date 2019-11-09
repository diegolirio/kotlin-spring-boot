package com.example.crudkotlin.controller

import com.example.crudkotlin.entity.Product
import com.example.crudkotlin.repository.ProductRepository
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("products")
class ProductController(val productRepository: ProductRepository) {

    @GetMapping
    fun getAll(): MutableIterable<Product> {
        return this.productRepository.findAll()
    }

    @PostMapping
    fun save(@RequestBody product: Product): Product {
        return this.productRepository.save(product)
    }

    @DeleteMapping
    fun delete(@PathVariable id: Long) {
        this.productRepository.deleteById(id)
    }

    @GetMapping
    fun getById(@PathVariable id: Long): Optional<Product> {
        return this.productRepository.findById(id)
    }

}