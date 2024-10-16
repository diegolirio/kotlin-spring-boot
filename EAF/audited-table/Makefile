.PHONY: setup build migrations fatjar docker-run

setup:
	./gradlew bootjar

docker-run: docker-build
	docker run -e DATABASE_URL=jdbc:postgresql://<IP>:<PORTA>/accounts \
			   -e DATABASE_USERNAME=postgres \
			   -e DATABASE_PASSWORD=postgres \
			   -e KEYCLOAK_CLIENT_ID=accounts_ser_client \
			   -e KEYCLOAK_CLIENT_SECRET=tqUyeh4AuJBtvuzIh8NY5EDzPNTHsAvu \
			   -e KEYCLOAK_API_URL=http://<IP>:<PORTA>/admin/realms/ser/users \
			   -e KEYCLOAK_CERT=http://1<IP>:<PORTA>/realms/ser/protocol/openid-connect/certs \
			   -e TOKEN_URL=http://<IP>:<PORTA>/realms/ser/protocol/openid-connect/token \
			   -e KEYCLOAK_API_GROUPS=http:/<IP>:<PORTA>/admin/realms/ser/groups \
			   -e KEYCLOAK_API_ROLES=http://<IP>:<PORTA>/admin/realms/ser/roles \
			   -e LOG_INFO=INFO \
			   -e PORT=8081 \
			   -e KAFKA_CREATE_ACCOUNTS_TOPIC=create_accounts \
			   -e KAFKA_UPDATED_ACCOUNTS_TOPIC=updated_accounts \
			   -e KAFKA_BROKERS=<IP>:<PORTA> \
			   -e MAIL_HOST=smtp.gmail.com \
			   -e MAIL_PASS=<PASSWORD> \
			   -e MAIL_PORT=587 \
			   -e MAIL_USER=<USER>> \
			   ser-accounts

docker-up:
	docker compose up -d

docker-down:
	docker compose down

build:
	./gradlew clean build -x test

test:
	./gradlew clean test --debug

lint:
	./gradlew ktlintCheck

lint-fix:
	./gradlew ktlintFormat

init-project: init-database-test init-database-accounts

init-database-accounts:
	export FILE_MIGRATIONS=accounts \
	export SCHEMA_MIGRATIONS_PASSWORD=audited \
  	export SCHEMA_MIGRATIONS_USER=audited \
    export DATABASE_JDBC_RW_URL=jdbc:postgresql://localhost:5432/accounts \
	export SCHEMA_MIGRATIONS=public;./gradlew flywayMigrate -i

init-database-test:
	export FILE_MIGRATIONS=test \
	export SCHEMA_MIGRATIONS_PASSWORD=audited \
  	export SCHEMA_MIGRATIONS_USER=audited \
    export DATABASE_JDBC_RW_URL=jdbc:postgresql://127.0.0.1:5432/accounts \
	export SCHEMA_MIGRATIONS=public;./gradlew :accounts:flywayMigrate -i

run:
	./gradlew bootRun

init: docker-down docker-up init-project

execute: docker-down docker-up