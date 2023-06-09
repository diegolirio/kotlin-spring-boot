package com.example.democacheabstraction.config

import org.apache.juli.logging.LogFactory
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.EnableCaching
import org.springframework.cache.concurrent.ConcurrentMapCache
import org.springframework.cache.support.SimpleCacheManager
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.Scheduled


@Configuration
@EnableCaching
class CacheAbstractionConfig {

    private val log = LogFactory.getLog(javaClass)

    @Bean
    fun cacheManagerCustomers(): CacheManager? {
        //return ConcurrentMapCacheManager("customers")
        val cacheManager = SimpleCacheManager()
        cacheManager.setCaches(
            listOf(
                ConcurrentMapCache("customers"),
                ConcurrentMapCache("token")
            )
        )
        return cacheManager
    }

//    @CacheEvict(value = ["customers"], allEntries = true)
//    @Scheduled(fixedRateString = "\${caching.spring.customersListTTL}")
//    fun emptyCustomersCache() {
//        log.info("emptying Customers cache")
//    }

    @CacheEvict(value = ["token"], allEntries = true)
    @Scheduled(fixedRateString = "\${caching.spring.tokenTTL}")
    fun emptyTokenCache() {
        log.info("emptying TOKEN cache")
    }

}