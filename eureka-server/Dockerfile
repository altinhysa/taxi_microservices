FROM azul/zulu-openjdk:17

RUN apt-get update
RUN apt-get install -y curl


EXPOSE 8761
COPY target/eureka-server-*.jar eureka-server.jar
ENTRYPOINT ["java","-jar","/eureka-server.jar"]