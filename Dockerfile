FROM openjdk:latest
ADD target/store-service-0.0.1-SNAPSHOT.jar store-service.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","store-service.jar"]