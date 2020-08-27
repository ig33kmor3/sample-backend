# create builder container to use maven
FROM maven:latest AS builder
WORKDIR /app
COPY . ./
RUN mvn clean package

# create container to run java webapi and set environment variables
FROM amazoncorretto:11.0.8
WORKDIR /app
COPY --from=builder /app/target/sample-backend-release.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-Xmx512m", "-jar", "sample-backend-release.jar"]