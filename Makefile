all: build

build:
	@./gradlew clean build

test:
	@./gradlew clean test

run:
	@./gradlew bootRun

clean:
	@./gradlew clean

container-start:
	@./gradlew clean bootJar
	@docker-compose -f docker-compose.yml up -d --remove-orphans --build

container-stop:
	@docker-compose down
	@docker rmi --force reactive-atdd-workshop

container-test:
	@./gradlew clean bootJar
	@docker-compose -f docker-compose.yml up -d --remove-orphans --build
	@./healthcheck.sh
	@docker-compose down
	@docker rmi --force reactive-atdd-workshop