# Step 1: Build with Maven
FROM maven:3.8.3-openjdk-17 as builder
WORKDIR /app
COPY . /app
RUN mvn clean install

# Step 2: Run with JRE
FROM openjdk:17-jdk-slim
WORKDIR /app
COPY --from=builder /app/target/demojpalab-0.0.1-SNAPSHOT.jar /app
EXPOSE 8080
CMD [ "java", "-jar", "demojpalab-0.0.1-SNAPSHOT.jar"]