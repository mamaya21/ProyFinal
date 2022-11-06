FROM openjdk:11
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} /eureka-server.jar
EXPOSE 8761
ENTRYPOINT ["java","-jar","/eureka-server.jar"]