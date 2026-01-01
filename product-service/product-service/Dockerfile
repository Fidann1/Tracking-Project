FROM openjdk:17.0.2-jdk-slim-bullseye

LABEL maintainer="fidanceferli"

WORKDIR /app

COPY build/libs/product-service-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-jar","app.jar"]