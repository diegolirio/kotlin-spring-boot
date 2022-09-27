import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.3" apply false
	id("io.spring.dependency-management") version "1.0.13.RELEASE" apply false
	id("io.gitlab.arturbosch.detekt") version "1.17.0"
	// id("com.github.davidmc24.gradle.plugin.avro") version "1.2.0"
	kotlin("jvm") version "1.6.21" apply false
	kotlin("plugin.spring") version "1.6.21" apply false
}

apply {
	plugin("io.gitlab.arturbosch.detekt")
}

group = "com.liriotech"
version = "0.0.1-SNAPSHOT"
// java.sourceCompatibility = JavaVersion.VERSION_11

buildscript {
	repositories {
		mavenCentral()
	}
}

allprojects {
	group = "com.liriotech"
	version = "1.0.0"

	tasks.withType<JavaCompile> {
		sourceCompatibility = "11"
		targetCompatibility = "11"
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "11"
		}
	}
}

subprojects {
	repositories {
		mavenCentral()
	}
	apply {
		plugin("io.spring.dependency-management")
		plugin("io.gitlab.arturbosch.detekt")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

//extra["springCloudVersion"] = "2021.0.3"
//
//dependencyManagement {
//	imports {
//		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
//	}
//}

detekt {
	input = files(
		"app/src/main/kotlin/",
		"domain/src/main/kotlin/"
	)
	config = files("default-detekt-config.yml")
	reports {
		txt.enabled = false
	}
	basePath = "$projectDir"
}