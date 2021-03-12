all: build

build:
	@./gradlew clean build

test:
	@./gradlew clean test

jacoco:
	@./gradlew jacocoTestReport

sonar:
	@./gradlew sonarqube --info

run:
	@./gradlew bootRun

clean:
	@./gradlew clean

bootJar:
	@./gradlew clean bootJar

container-start:
	@./gradlew clean bootJar
	@docker-compose -f docker-compose.yml up -d --remove-orphans --build

container-stop:
	@docker-compose down
	@docker rmi --force reactive-atdd-workshop

container-test:
	@./gradlew clean bootJar
	@docker-compose -f docker-compose.yml up -d --remove-orphans --build
	@./gradlew clean integrationTest
	@docker-compose down
	@docker rmi --force reactive-atdd-workshop