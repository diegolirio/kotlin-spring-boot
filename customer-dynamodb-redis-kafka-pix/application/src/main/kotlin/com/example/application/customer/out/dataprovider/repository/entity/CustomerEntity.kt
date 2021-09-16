package com.example.application.customer.out.dataprovider.repository.entity

import com.amazonaws.services.dynamodbv2.datamodeling.*

@DynamoDBTable(tableName = CustomerEntity.TABLE_NAME)
data class CustomerEntity(

        @DynamoDBHashKey
        @DynamoDBAttribute
        var id: String? = null,

        @DynamoDBAttribute
        var name: String? = null,

        @DynamoDBAttribute
        var age: Int? = null,

//        @DynamoDBAttribute
//        @DynamoDBIndexHashKey(globalSecondaryIndexName = INDEX_USERNAME)
//        @DynamoDBTypeConvertedEnum
//        var username: String? = null,

) {

    companion object {
        const val TABLE_NAME = "poc-customers"
//        const val INDEX_USERNAME = "${TABLE_NAME}_username_idx"
    }
}