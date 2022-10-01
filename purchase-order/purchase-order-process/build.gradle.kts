import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	//id("io.gitlab.arturbosch.detekt") version "1.17.0"
	kotlin("jvm") version "1.6.21" apply false
	kotlin("plugin.spring") version "1.6.21" apply false
}

//apply {
//	plugin("io.gitlab.arturbosch.detekt")
//}

buildscript {
	repositories {
		mavenCentral()
	}
}

//subprojects {
//	repositories {
//		mavenCentral()
//	}
//	apply {
//		plugin("io.gitlab.arturbosch.detekt")
//	}
//}


//detekt {
//	input = files(
//		"app/src/main/kotlin/",
//		"domain/src/main/kotlin/"
//	)
//	config = files("default-detekt-config.yml")
//	reports {
//		txt.enabled = false
//	}
//	basePath = "$projectDir"
//}