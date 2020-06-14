FROM java:8-jre

ADD ./target/seller-service-0.0.1-SNAPSHOT.jar /app/
ENTRYPOINT ["java", "-Xmx200m", "-jar", "/app/seller-service-0.0.1-SNAPSHOT.jar"]

EXPOSE 8082