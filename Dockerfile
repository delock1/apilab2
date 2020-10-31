FROM maven:3.5.2-jdk-8-alpine
COPY /target/apilab-1.0.jar apilab.jar
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom","-jar","/apilab.jar"]