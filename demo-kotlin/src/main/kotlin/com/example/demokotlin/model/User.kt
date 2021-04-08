package com.example.demokotlin.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class User(
    @Id var _id: String? = null,
    var name: String? = null
)