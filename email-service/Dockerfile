FROM azul/zulu-openjdk:17
EXPOSE 8082
COPY target/email-service-*.jar email-service.jar
ENTRYPOINT ["java","-jar","/email-service.jar"]