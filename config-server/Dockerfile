FROM openjdk:11
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} /config-server.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/config-server.jar"]