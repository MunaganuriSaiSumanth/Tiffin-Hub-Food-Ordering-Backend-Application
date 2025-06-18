FROM eclipse-temurin:21-jdk-alpine
COPY target/hub.jar tiffinhub-con.jar
ENTRYPOINT ["java", "-jar", "/tiffinhub-con.jar"]