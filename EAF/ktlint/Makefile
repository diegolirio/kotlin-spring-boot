clean:
    ./gradlew clean build

setup:
	./gradlew bootjar

build: lint
    ./gradlew clean build -x test

test:
    ./gradlew test

lint:
    ./gradlew ktlintCheck

lint-fix:
    ./gradlew ktlintFormat