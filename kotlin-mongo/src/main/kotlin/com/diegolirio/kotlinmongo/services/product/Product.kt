package com.diegolirio.kotlinmongo.services.product

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
@JsonIgnoreProperties(ignoreUnknown=true)
class Product(@Id val id : String,
              val description: String,
              val price: Number) {


}
