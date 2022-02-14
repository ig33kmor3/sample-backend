# compliation build - https://www.docker.com/blog/faster-multi-platform-builds-dockerfile-cross-compilation-guide/
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