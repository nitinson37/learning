FROM openjdk:8-jdk-alpine
#WORKDIR /rest-service_solution
#COPY . .
#RUN mvn clean install -DskipTests
#CMD mvn spring-boot:run
COPY target/backend-coding-challenge-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]