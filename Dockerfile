FROM openjdk:11-slim-buster

RUN mkdir /reactive-atdd-workshop
COPY ./build/libs/reactive-atdd-workshop*.jar /reactive-atdd-workshop/reactive-atdd-workshop.jar

CMD ["java","-jar","/reactive-atdd-workshop/reactive-atdd-workshop.jar"]