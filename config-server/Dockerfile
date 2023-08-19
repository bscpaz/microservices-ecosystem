# Stage 1: Build the application
FROM eclipse-temurin:17-jdk-alpine AS build

WORKDIR /opt/api/app

# Copy only the pom.xml and build the dependencies to leverage Docker caching
# This step will be cached unless pom.xml changes
COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
RUN ./mvnw dependency:go-offline

# Copy the rest of the source code and build the application
COPY src src
RUN ./mvnw package -DskipTests

# Estage 2:
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /opt/api/app

RUN addgroup -S spring && adduser -S spring -G spring

COPY --from=build /opt/api/app/target/*.jar /opt/api/app/config-server.jar
RUN mkdir -p /opt/api/config && chown -R spring:spring /opt/api

USER spring:spring

ENTRYPOINT ["java","-jar","/opt/api/app/config-server.jar"]