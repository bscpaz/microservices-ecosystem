FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /opt/app

COPY ./pom.xml ./
RUN mvn dependency:go-offline

COPY ./src ./src
RUN mvn clean package

FROM eclipse-temurin:17-jdk-alpine

WORKDIR /opt/app

RUN addgroup -S spring && adduser -S spring -G spring

COPY --from=build /opt/app/target/*.jar /opt/app/desafio-api.jar
RUN chown -R spring:spring /opt

USER spring:spring

ENTRYPOINT ["java","-jar","/opt/app/desafio-api.jar"]
