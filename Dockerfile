# Use a lightweight Java 17 image
FROM openjdk:17-jdk-slim

# Set working directory inside the container
WORKDIR /app

# Copy everything from your project into the container
COPY . .

COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .


RUN chmod +x mvnw

RUN ./mvnw dependency:go-offline -B
COPY src ./src

# Build the project using Maven wrapper
RUN ./mvnw clean package -DskipTests

# Expose port 8080 (Spring Boot default)
EXPOSE 8080

# Run the built JAR file
CMD ["sh","-c","java -jar target/*.jar"]