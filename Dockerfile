FROM openjdk:22-jdk-slim
EXPOSE 8080
ADD target/flight_booking-0.0.1-SNAPSHOT.jar flight_booking-0.0.1-SNAPSHOT.jar
ADD env.properties env.properties
ENTRYPOINT ["java","-jar","/flight_booking-0.0.1-SNAPSHOT.jar"]