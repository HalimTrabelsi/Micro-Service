FROM openjdk:17
EXPOSE 8083
ADD  target/EurekaServer-0.0.1-SNAPSHOT.jar EurekaServer.jar
ENTRYPOINT ["java", "-jar" , "EurekaServer.jar"]