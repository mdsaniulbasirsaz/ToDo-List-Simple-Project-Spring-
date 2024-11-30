# Stage 1: Build the application
FROM maven:3.8.5-openjdk-17 AS build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn clean install -DskipTests

# Copy the source code
COPY src /app/src

# Build the project
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM openjdk:17-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the JAR file from the build stage
COPY --from=build /app/target/todolist-app-0.0.1-SNAPSHOT.jar /app/todolist-app.jar

# Expose the port the app will run on
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/todolist-app.jar"]
