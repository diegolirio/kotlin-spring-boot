package com.example.e2e.demospringdatar2dbc.repository

import io.r2dbc.spi.ConnectionFactory
import org.springframework.stereotype.Repository


@Repository
class CustodyRepositoryImpl(
        private val connectionFactory: ConnectionFactory
) {

//    fun inserirEmLote(registros: List<CustodyEntity>): Flux<CustodyEntity> {
//        val sql = "INSERT INTO custody (customerId) VALUES (?)"
//
//        jdbcTemplate.batchUpdate(sql, object : BatchPreparedStatementSetter {
//
//            override fun setValues(ps: PreparedStatement, i: Int) {
//                val registro: CustodyEntity = registros[i]
//                ps.setString(1, registro.customerId)
//            }
//
//            override fun getBatchSize(): Int {
//                return registros.size
//            }
//        })
//        return Flux.fromIterable(registros)
//    }

}