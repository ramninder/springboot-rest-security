FROM adoptopenjdk/openjdk11:latest
ADD target/springsecurity-0.0.1-SNAPSHOT.jar spring-security.jar
ENTRYPOINT ["java", "-jar", "spring-security.jar"]
