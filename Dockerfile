FROM openjdk:11-jdk
COPY /target/mssc-beer-inventory-service-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=test", "mssc-beer-inventory-service-0.0.1-SNAPSHOT.jar"]
EXPOSE 8082