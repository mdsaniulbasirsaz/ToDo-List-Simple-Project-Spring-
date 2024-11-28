# Use a base image with JDK 17 (or any version you are using)
FROM openjdk:17-jdk-slim as build

# Set the working directory
WORKDIR /app

# Copy the pom.xml and download dependencies
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the source code and compile the app
COPY src ./src
RUN mvn clean package -DskipTests

# Final image
FROM openjdk:17-jdk-slim

# Set the working directory for the app
WORKDIR /app

# Copy the jar file from the previous build stage
COPY --from=build /app/target/*.jar /app/app.jar

# Expose the port the app will run on (default for Spring Boot is 8080)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
