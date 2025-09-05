# Use official OpenJDK as base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Give execute permission to mvnw
RUN chmod +x ./mvnw

# Build application (skip tests to make faster)
RUN ./mvnw clean package -DskipTests

# Run Spring Boot JAR
CMD ["java", "-jar", "target/*.jar"]
