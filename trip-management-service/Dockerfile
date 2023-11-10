FROM azul/zulu-openjdk:17
EXPOSE 8081
COPY target/trip-management-service-*.jar trip-service.jar
ENTRYPOINT ["java","-jar","/trip-service.jar"]