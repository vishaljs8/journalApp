# Use Eclipse Temurin JDK 17 (lightweight Alpine version)
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside container
WORKDIR /app

# Copy the built JAR from target folder
COPY target/journalApp-0.0.1-SNAPSHOT.jar app.jar

# Expose default Spring Boot port
EXPOSE 8080

# Command to run the app
ENTRYPOINT ["java", "-jar", "app.jar"]

