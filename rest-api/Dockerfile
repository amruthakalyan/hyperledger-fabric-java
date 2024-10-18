FROM openjdk:11-jre-slim

VOLUME /tmp

ARG JAR_FILE=target/rest-api-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","/app.jar"]
