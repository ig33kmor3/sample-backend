# Sample Backend

Sample application for testing Java Spring Boot API configurations in the cloud.

## Routes

```bash
curl http://localhost:8080/v1/cars | json_pp
```

## Build

```bash
mvn clean package
docker build -t sample-backend:# .
```

## Dockerfile

```dockerfile
# create builder container to use maven
FROM maven:latest AS builder
WORKDIR /app
COPY . ./
RUN mvn clean package

# create container to run java webapi and set environment variables
FROM amazoncorretto:17-alpine-jdk
WORKDIR /app
COPY --from=builder /app/target/sample-backend-release.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "sample-backend-release.jar"]
```