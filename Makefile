all: build

build:
	@./backend/gradlew -p ./backend clean build
	@npm install --prefix ./frontend

test:
	@./backend/gradlew -p ./backend clean test

jacoco:
	@./backend/gradlew -p ./backend jacocoTestReport

sonar:
	@./backend/gradlew -p ./backend sonarqube --info

run:
	@./backend/gradlew -p ./backend bootRun

clean:
	@./backend/gradlew -p ./backend clean
	@rm -rf ./frontend/node_modules

bootJar:
	@./backend/gradlew -p ./backend clean bootJar

container-start:
	@./backend/gradlew -p ./backend clean bootJar
	@npm install --prefix ./frontend
	@docker-compose -f docker-compose.yml up -d --remove-orphans --build

container-stop:
	@docker-compose down
	@docker rmi --force reactive-atdd-workshop-frontend
	@docker rmi --force reactive-atdd-workshop-backend

container-test:
	@./backend/gradlew -p ./backend clean bootJar
	@npm install --prefix ./frontend
	@docker-compose -f docker-compose.yml up -d --remove-orphans --build
	@./healthcheck.sh
	@./backend/gradlew -p ./backend clean integrationTest
	@docker-compose down
	@docker rmi --force reactive-atdd-workshop-frontend
	@docker rmi --force reactive-atdd-workshop-backend