FROM openjdk:11
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} /ms-customerNatural-product.jar
EXPOSE 8083
ENTRYPOINT ["java","-jar","/ms-customerNatural-product.jar"]