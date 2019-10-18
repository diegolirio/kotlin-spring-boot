package io.github.diegolirio.userimc.user.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import io.github.diegolirio.userimc.user.types.ClassificationType

@Document
class User(
        val fullname: String? = "",
        val age: Int? = 0,
        val height: Float = 0F,
        val weight: Float = 0F,
        val email: String? = "") {


    @Id
    var id: String? = null

    var imc: Float = 0F
    var classification = ClassificationType.NORMAL

    //constructor(fullname: String?, age: Int, height: Float, weight: Float, email: String)
    //       : this(null, fullname, age, height, weight, email)

}
