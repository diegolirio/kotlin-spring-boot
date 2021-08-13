import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.5.3" apply false
	id("io.spring.dependency-management") version "1.0.11.RELEASE" apply false
	kotlin("jvm") version "1.5.21" apply false
	kotlin("plugin.spring") version "1.5.21" apply false
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
// java.sourceCompatibility = JavaVersion.VERSION_11

buildscript {
	repositories {
		mavenCentral()
	}
}

allprojects {
	group = "com.example"
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
