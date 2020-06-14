FROM java:8-jre

ADD ./target/zuul-gateway-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-Xmx200m", "-jar", "/app/zuul-gateway-0.0.1-SNAPSHOT.jar"]

EXPOSE 8000