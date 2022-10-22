FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /opt/app
ARG JAR_FILE=/target/app-videos-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app-videos.jar
ENTRYPOINT ["java", "-jar", "app-videos.jar"]