FROM java:11
ADD target/springsecurity-0.0.1-SNAPSHOT.jar spring-security.jar
ENTRYPOINT ["java", "-jar", "spring-security.jar"]
EXPOSE 9091