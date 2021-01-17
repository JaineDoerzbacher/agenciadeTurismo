FROM openjdk:11
MAINTAINER jaine
WORKDIR /opt/app


ARG JAR_FILE=build/libs/tuor-0.0.1-SNAPSHOT.jar

COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]