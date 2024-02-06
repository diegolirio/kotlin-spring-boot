//package com.example.e2e.demospringdatar2dbc.config
//
//import io.r2dbc.spi.ConnectionFactory
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
//import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories
//
//
//@Configuration
//@EnableR2dbcRepositories
//class DatabaseConfig : AbstractR2dbcConfiguration() {
//    @Bean
//    override fun connectionFactory(): ConnectionFactory {
//        return PostgresqlConnectionFactory(
//                PostgresqlConnectionConfiguration.builder()
//                        .host("localhost")
//                        .port(5432)
//                        .username("postgres")
//                        .password("postgres")
//                        .database("mydatabase")
//                        .build())
//    }
//}