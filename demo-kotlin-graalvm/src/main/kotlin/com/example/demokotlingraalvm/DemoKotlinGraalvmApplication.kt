package com.example.demokotlingraalvm

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan

@SpringBootApplication
@ComponentScan(basePackages = ["com.example"])
class DemoKotlinGraalvmApplication {

	//companion object {
		fun main(args: Array<String>) {
			runApplication<DemoKotlinGraalvmApplication>(*args)
		}
	//}
}

fun main(args: Array<String>) {
	runApplication<DemoKotlinGraalvmApplication>(*args)
}