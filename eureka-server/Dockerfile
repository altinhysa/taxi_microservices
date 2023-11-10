FROM azul/zulu-openjdk:17
EXPOSE 8761
COPY target/eureka-server-*.jar eureka-server.jar
ENTRYPOINT ["java","-jar","/eureka-server.jar"]