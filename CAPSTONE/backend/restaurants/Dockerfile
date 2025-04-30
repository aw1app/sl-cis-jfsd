FROM openjdk:17-jdk-slim
WORKDIR /app
COPY target/restaurants.jar restaurants.jar
ENTRYPOINT ["java", "-jar", "restaurants.jar"]
