# sampleBackend

Sample application for testing Java Spring Boot API configurations in the cloud.

## Routes

```bash
$ curl http://localhost:8080/v1/cars | json_pp
```

## Local Build Process
```bash
$ mvn clean package

$ docker build -t sample-backend:# .
```