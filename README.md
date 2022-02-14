# Sample Backend

Sample application for testing Java Spring Boot API configurations in the cloud.

## Routes

```bash
curl http://localhost:8080/v1/cars | json_pp
```

## Build on AMD64

```bash
mvn clean package
docker build -t sample-backend:1.0.0 .
```

## Build on M1

```bash
docker buildx build --platform=linux/amd64 -t sample-backend:1.0.0 .
```

## Dockerfile 

https://www.docker.com/blog/faster-multi-platform-builds-dockerfile-cross-compilation-guide/

```dockerfile
# create builder container to use maven
FROM --platform=linux/amd64 maven:3-amazoncorretto-17 AS builder
WORKDIR /app
COPY . ./
RUN mvn clean package

# create container to run java webapi and set environment variables
FROM --platform=linux/amd64 amazoncorretto:17-alpine
WORKDIR /app
COPY --from=builder /app/target/sample-backend-release.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "sample-backend-release.jar"]
```