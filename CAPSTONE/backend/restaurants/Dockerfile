FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/restaurants-0.0.1-SNAPSHOT.jar restaurants.jar
ENTRYPOINT ["java", "-jar", "restaurants.jar"]
