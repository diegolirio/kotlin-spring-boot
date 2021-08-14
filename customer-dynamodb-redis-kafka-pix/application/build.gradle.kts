plugins {
    id("org.springframework.boot")

    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
	implementation(project(":domain"))
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-redis")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	//runtimeOnly("io.micrometer:micrometer-registry-new-relic")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("com.amazonaws:aws-java-sdk-dynamodb:1.11.740")
	implementation("com.amazonaws:aws-java-sdk-core:1.11.740")
	implementation("redis.clients:jedis")
	implementation("io.github.microutils:kotlin-logging:1.6.26")
}

