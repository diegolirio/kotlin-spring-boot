plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.flywaydb.flyway") version "8.5.11"
	id("org.springframework.boot") version "3.3.4"
	id("io.spring.dependency-management") version "1.1.6"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-r2dbc")
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

	implementation("org.flywaydb:flyway-core:8.5.11")
	//implementation("org.flywaydb:flyway-core")
	//implementation("org.flywaydb:flyway-database-postgresql")

	runtimeOnly("org.postgresql:postgresql")
	runtimeOnly("org.postgresql:r2dbc-postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

flyway {
	val migrationsDir by lazy {
		val projectRootDir = System.getProperty("user.dir")
		"filesystem:/$projectRootDir/src/main/resources/db/migrations"
	}
	url = System.getenv("DATABASE_JDBC_RW_URL")
	user = System.getenv("SCHEMA_MIGRATIONS_USER")
	password = System.getenv("SCHEMA_MIGRATIONS_PASSWORD")
	schemas = arrayOf(System.getenv("SCHEMA_MIGRATIONS"))
	baselineOnMigrate = true
	locations = arrayOf(migrationsDir)
	createSchemas = true
}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
