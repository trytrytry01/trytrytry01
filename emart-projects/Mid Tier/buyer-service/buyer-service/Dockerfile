FROM java:8-jre

ADD ./target/buyer-service-0.0.1-SNAPSHOT.jar /app/
CMD ["java", "-Xmx200m", "-jar", "/app/buyer-service-0.0.1-SNAPSHOT.jar"]

EXPOSE 8083