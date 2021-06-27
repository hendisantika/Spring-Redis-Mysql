FROM openjdk:8-jdk-alpine
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} country-service.jar

ENTRYPOINT ["java","-jar","/country-service.jar"]
