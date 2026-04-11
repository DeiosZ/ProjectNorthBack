#-Compilacion--------
FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /app
COPY pom.xml .
COPY mvnw .
COPY .mvn .mvn
COPY src ./src

RUN chmod +x mvnw && ./mvnw clean package -DskipTests
#-ImagenFinal--------
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

COPY --from=builder /app/target/northback-0.0.1.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]