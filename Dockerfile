# Use official OpenJDK as base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper & project files
COPY . .

# Build application (skip tests to make faster)
RUN ./mvnw clean package -DskipTests

# Run Spring Boot JAR (the JAR will be inside /app/target/)
CMD ["java", "-jar", "target/*.jar"]
