
setup:
	./gradlew bootjar

docker-up:
	docker compose up -d

docker-down:
	docker compose down

init-database-files:
	export FILE_MIGRATIONS=files \
	export SCHEMA_MIGRATIONS_PASSWORD=postgres \
  	export SCHEMA_MIGRATIONS_USER=postgres \
    export DATABASE_JDBC_RW_URL=jdbc:postgresql://localhost:5432/flyway \
	export SCHEMA_MIGRATIONS=public;./gradlew :flywayMigrate -i