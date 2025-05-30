# Build da aplicação com Maven e Java 17
FROM maven:3.8.7-eclipse-temurin-17 AS build

WORKDIR /app

COPY global-solution /app

RUN mvn package -DskipTests

# Imagem para rodar o app (Java 17 JRE)
FROM eclipse-temurin:17-jre-alpine

WORKDIR /app

COPY --from=build /app/target/global-solution-1.0.0-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]