# ---------- STAGE 1: Build the application ----------
FROM maven:3.9.6-eclipse-temurin-17 AS build

# Set working directory
WORKDIR /app

# Copy pom.xml và tải dependencies (cache layer)
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code và build
COPY src ./src
RUN mvn clean package -DskipTests

# ---------- STAGE 2: Run the application ----------
FROM eclipse-temurin:17-jdk

# Set working directory
WORKDIR /app

# Copy jar file từ stage build sang stage run
COPY --from=build /app/target/*.jar app.jar

# Expose port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
