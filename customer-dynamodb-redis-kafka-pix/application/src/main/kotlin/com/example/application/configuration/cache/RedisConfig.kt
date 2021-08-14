package com.example.application.configuration.cache

import mu.KLogger
import mu.KotlinLogging
import org.springframework.beans.factory.annotation.Value
import org.springframework.cache.Cache
import org.springframework.cache.CacheManager
import org.springframework.cache.annotation.CachingConfigurerSupport
import org.springframework.cache.interceptor.CacheErrorHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.cache.RedisCacheConfiguration
import org.springframework.data.redis.cache.RedisCacheManager
import org.springframework.data.redis.cache.RedisCacheWriter
import org.springframework.data.redis.connection.RedisStandaloneConfiguration
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.serializer.GenericToStringSerializer
import org.springframework.data.redis.serializer.StringRedisSerializer
import java.io.Serializable
import java.time.Duration

@Configuration
class RedisConfig : CachingConfigurerSupport() {

    @Value("\${cache.redis.defaultTimeToLive:60}")
    val defaultCacheExpiration: Long = 60L

    @Value("\${cache.redis.longTimeToLive:3600}")
    val longTimeCacheExpiration: Long = 3600L

    @Value("\${cache.redis.mediumTimeToLive:300}")
    val mediumTimeCacheExpiration: Long = 300L
    
    @Value("\${cache.redis.host}")
    lateinit var redisHostName: String

    @Value("\${cache.redis.port:0}")
    var redisPort: Int = 0

    @Value("\${cache.redis.timeout:5000}")
    var timeout: Long = 5000L

    @Bean
    fun redisConnectionFactory(): JedisConnectionFactory {

        val redisConfiguration = RedisStandaloneConfiguration(redisHostName, redisPort)

        val clientConfiguration = JedisClientConfiguration.builder()
                .readTimeout(Duration.ofMillis(timeout))
                .connectTimeout(Duration.ofMillis(timeout))
                .build()

        return JedisConnectionFactory(redisConfiguration, clientConfiguration)
    }

    @Bean
    fun cacheConfigurations(): Map<String, RedisCacheConfiguration> {
        val caches = mutableMapOf<String, RedisCacheConfiguration>()
        // TODO
        caches.putIfAbsent(CUSTOMERS_CACHE, longTimeRedisConfiguration())
        caches.putIfAbsent(CUSTOMERS_BY_ID_CACHE, longTimeRedisConfiguration())
        return caches
    }
    
    @Bean
    fun redisCacheWriter(): RedisCacheWriter {
        return RedisCacheWriter.lockingRedisCacheWriter(redisConnectionFactory())
    }

    @Bean
    fun defaultRedisCacheConfiguration(): RedisCacheConfiguration {
        return RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(defaultCacheExpiration))
    }

    @Bean
    fun longTimeRedisConfiguration(): RedisCacheConfiguration {
        return RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(longTimeCacheExpiration))
    }

    @Bean
    fun mediumTimeRedisConfiguration(): RedisCacheConfiguration {
        return RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofSeconds(mediumTimeCacheExpiration))
    }
    
    @Bean
    override fun cacheManager(): CacheManager {
        return RedisCacheManager(redisCacheWriter(), defaultRedisCacheConfiguration(), cacheConfigurations())
    }

    @Override
    override fun errorHandler(): CacheErrorHandler {
        return RedisCacheErrorHandler()
    }

    @Bean
    fun redisTemplate(): RedisTemplate<String, Serializable> {
        val redisTemplate = RedisTemplate<String, Serializable>()
        redisTemplate.setConnectionFactory(redisConnectionFactory())
        redisTemplate.keySerializer = StringRedisSerializer()
        redisTemplate.hashValueSerializer = GenericToStringSerializer(String::class.java)
        redisTemplate.valueSerializer = GenericToStringSerializer(String::class.java)
        return redisTemplate
    }

    class RedisCacheErrorHandler(private val log: KLogger = KotlinLogging.logger {}) : CacheErrorHandler {

        override fun handleCacheGetError(exception: RuntimeException, cache: Cache, key: Any) {
            log.warn("Unable to get from cache " + cache.name + " : " + exception.message)
        }

        override fun handleCachePutError(exception: java.lang.RuntimeException, cache: Cache, key: Any, value: Any?) {
            log.warn("Unable to put into cache " + cache.name + " : " + exception.message)
        }

        override fun handleCacheEvictError(exception: java.lang.RuntimeException, cache: Cache, key: Any) {
            log.warn("Unable to evict from cache " + cache.name + " : " + exception.message)
        }

        override fun handleCacheClearError(exception: RuntimeException, cache: Cache) {
            log.warn("Unable to clean cache " + cache.name + " : " + exception.message)
        }
    }

    companion object {
        const val CUSTOMERS_CACHE = "CUSTOMERS_CACHE"
        const val CUSTOMERS_BY_ID_CACHE = "CUSTOMERS_BY_ID_CACHE"
    }
}