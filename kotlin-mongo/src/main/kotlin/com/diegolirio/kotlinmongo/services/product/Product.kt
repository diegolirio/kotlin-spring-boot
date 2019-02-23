package com.diegolirio.kotlinmongo.services.product

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
class Product(@Id val id : String,
              val description: String,
              val price: Number) {


}
