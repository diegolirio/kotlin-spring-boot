package com.diegolirio.kotlinmongo.services.product

import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductService(private val productRepository: ProductRepository) {

    fun getAll(): List<Product> {
        return productRepository.findAll()
    }

    fun save(product: Product): Product {
        return productRepository.save(product)
    }

    fun delete(id: String) {
        productRepository.deleteById(id)
    }

    fun getById(id: String): Optional<Product> {
        return productRepository.findById(id)
    }

}