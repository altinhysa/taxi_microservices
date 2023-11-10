FROM azul/zulu-openjdk:17
EXPOSE 8083
COPY target/passenger-management-service-*.jar passenger-service.jar
ENTRYPOINT ["java","-jar","/passenger-service.jar"]