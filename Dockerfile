FROM ubuntu:latest as build

RUN apt-get update 
RUN apt-get install openjdk-21-jdk -y

COPY . .

RUN apt-get install maven -y
RUN mvn clean install

FROM openjdk:21-slim

EXPOSE 8080

COPY --from=build /workspace/target/agenda-1.0.0.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]