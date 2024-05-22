FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app
COPY target/appone-0.0.1-SNAPSHOT.jar appone.jar
EXPOSE 8080
CMD ["java","-jar","appone.jar"]
