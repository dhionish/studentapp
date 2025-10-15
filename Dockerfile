# Use a lightweight Java 17 image
FROM eclipse-temurin:17-jdk-alpine

# Set working directory inside the container
WORKDIR /app

# Copy everything from your project into the container
COPY . .

# Build the project using Maven wrapper
RUN ./mvnw clean package -DskipTests

# Expose port 8080 (Spring Boot default)
EXPOSE 8080

# Run the built JAR file
CMD ["java", "-jar", "target/demo-0.0.1-SNAPSHOT.jar"]