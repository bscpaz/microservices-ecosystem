# Estage 1:
FROM eclipse-temurin:17-jdk-alpine AS build

WORKDIR /opt/api/app

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
RUN ./mvnw dependency:go-offline

COPY src src
RUN ./mvnw package -DskipTests

# Estage 2:
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /opt/api/app

RUN addgroup -S spring && adduser -S spring -G spring

COPY --from=build /opt/api/app/target/*.jar /opt/api/app/gateway.jar
RUN chown -R spring:spring /opt/api/app

USER spring:spring

ENTRYPOINT ["java","-jar","/opt/api/app/gateway.jar"]