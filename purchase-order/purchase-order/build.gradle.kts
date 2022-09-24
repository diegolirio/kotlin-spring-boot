import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.4"
	id("io.spring.dependency-management") version "1.0.14.RELEASE"
	id("io.gitlab.arturbosch.detekt") version "1.17.0"
	id("com.github.davidmc24.gradle.plugin.avro") version "1.2.0"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

val confluentUrl: String by project
extra["springCloudVersion"] = "2021.0.4"

group = "com.liriotech"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
	maven { url = uri(confluentUrl) }
}

dependencies {
	implementation("javax.inject:javax.inject:1")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	implementation("org.springframework.boot:spring-boot-starter-data-mongodb-reactive")
	implementation("de.flapdoodle.embed:de.flapdoodle.embed.mongo")

	implementation("org.springframework.kafka:spring-kafka")
	implementation("org.apache.avro:avro:1.10.2")
	implementation("io.confluent:kafka-avro-serializer:6.2.0")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
}

tasks.withType<com.github.davidmc24.gradle.plugin.avro.GenerateAvroJavaTask> {
	source("src/main/resources/avro")
	setOutputDir(file("src/main/kotlin"))
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks {
	bootJar {
		archiveFileName.set("app.jar")
	}
}

detekt {
	input = files(
		"src/main/kotlin/"
	)
	config = files("default-detekt-config.yml")
	reports {
		txt.enabled = false
	}
	basePath = "$projectDir"
}