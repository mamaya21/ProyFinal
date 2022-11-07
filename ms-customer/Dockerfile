FROM openjdk:11
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} /ms-customerNatural.jar
EXPOSE 8085
ENTRYPOINT ["java","-jar","/ms-customerNatural.jar"]