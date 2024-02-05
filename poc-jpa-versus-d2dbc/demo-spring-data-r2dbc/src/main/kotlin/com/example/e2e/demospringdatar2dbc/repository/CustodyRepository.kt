package com.example.e2e.demospringdatar2dbc.repository

import com.example.e2e.demospringdatar2dbc.entity.CustodyEntity
import org.springframework.data.repository.reactive.ReactiveCrudRepository


interface CustodyRepository : ReactiveCrudRepository<CustodyEntity, Long> {

//    fun findAll2(): Flux<CustodyEntity> {
//        val client = DatabaseClient.create(connectionFactory)
//        return client.sql("select * from student")
//                .map<Any> { row: Readable ->
//                    Student(row["id", Long::class.java],
//                            row["name", String::class.java],
//                            row["address", String::class.java])
//                }.all()
//    }


}
