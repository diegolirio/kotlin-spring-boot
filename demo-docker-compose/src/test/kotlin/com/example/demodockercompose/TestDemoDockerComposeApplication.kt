package com.example.demodockercompose

import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.with

@TestConfiguration(proxyBeanMethods = false)
class TestDemoDockerComposeApplication

fun main(args: Array<String>) {
	fromApplication<DemoDockerComposeApplication>().with(TestDemoDockerComposeApplication::class).run(*args)
}
