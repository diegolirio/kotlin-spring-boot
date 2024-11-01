package com.example.demo

import jakarta.servlet.http.HttpServletRequest
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.web.SecurityFilterChain
import org.springframework.stereotype.Component
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
class SecurityConfig(
    private val customCorsConfiguration: CustomCorsConfiguration,
) {
    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .cors { c -> c.configurationSource(customCorsConfiguration) }
//        .cors {
//                // it.disable()
//                it.configurationSource {
//                    CorsConfiguration().apply {
//                        allowedOrigins = listOf("*")
//                        allowedMethods = listOf("*")
//                        allowedHeaders = listOf("*")
//                        allowCredentials = true
//                    }
//                }
//            }
            .csrf { it.disable() }
            .authorizeHttpRequests { authorizeRequests ->
                authorizeRequests
                    .requestMatchers("/**")
                    .authenticated()
                    .anyRequest()
                    .permitAll()
            }
        return http.build()
    }
}

@Component
class CustomCorsConfiguration : CorsConfigurationSource {
    override fun getCorsConfiguration(request: HttpServletRequest): CorsConfiguration? {
        val config = CorsConfiguration()
        config.allowedOrigins = listOf("http://localhost:8081", "http://127.0.0.1:8081")
        config.allowedMethods = listOf("GET", "POST", "PUT", "DELETE")
        config.allowedHeaders = listOf("*")
        return config
    }
}
