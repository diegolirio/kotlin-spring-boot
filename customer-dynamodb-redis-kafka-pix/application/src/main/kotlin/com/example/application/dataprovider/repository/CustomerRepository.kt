package com.example.application.dataprovider.repository

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression
import com.example.application.dataprovider.repository.entity.CustomerEntity
import org.springframework.stereotype.Repository

@Repository
class CustomerRepository(
        private val dynamoDBMapper: DynamoDBMapper
) {

    fun domainClass() = CustomerEntity::class.java

    fun findAll(): List<CustomerEntity>? {
        return dynamoDBMapper.scan(domainClass(), DynamoDBScanExpression()) ?: listOf()
    }

    fun save(entity: CustomerEntity): CustomerEntity {
        dynamoDBMapper.save(entity)
        return entity
    }

    fun findById(id: String): CustomerEntity = dynamoDBMapper.load(domainClass(), id)

    fun delete(entity: CustomerEntity): CustomerEntity {
        dynamoDBMapper.delete(entity)
        return entity
    }

}