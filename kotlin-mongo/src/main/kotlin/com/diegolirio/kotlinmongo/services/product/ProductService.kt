package com.diegolirio.kotlinmongo.services.product

import org.springframework.stereotype.Service
import java.util.*

interface ProductService {

    fun getAll(): List<Product>
    fun save(product: Product): Product
    fun delete(id: String)
    fun getById(id: String): Optional<Product>

}

@Service
class ProductServiceImpl  (private val productRepository: ProductRepository) : ProductService {

    override fun getAll(): List<Product> {
        return productRepository.findAll()
    }

    override fun save(product: Product): Product {
        return productRepository.save(product)
    }

    override fun delete(id: String) {
        productRepository.deleteById(id)
    }

    override fun getById(id: String): Optional<Product> {
        return productRepository.findById(id)
    }

}