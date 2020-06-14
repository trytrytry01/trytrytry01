FROM java:8-jre

ADD ./target/eureka-server-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-Xmx200m", "-jar", "/app/eureka-server-0.0.1-SNAPSHOT.jar"]

EXPOSE 8761