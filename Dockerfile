FROM openjdk:11-jre-slim

ENV JAVA_ENV=PRODUCTION
ENV KUMULUZEE_ENV_NAME=prod
ENV KUMULUZEE_ENV_PROD=true
ENV KUMULUZEE_LOGS_LOGGERS0_LEVEL=INFO

ENV KUMULUZEE_STREAMING_KAFKA_PRODUCER_BOOTSTRAP-SERVERS=localhost:9092
ENV KUMULUZEE_STREAMING_KAFKA_CONSUMER_BOOTSTRAP-SERVERS=localhost:9092
ENV KUMULUZEE_STREAMING_KAFKA_CONSUMER_GROUP-ID=group1


RUN mkdir /app
WORKDIR /app

ADD ./api/v1/target/kafka-tester.jar /app

EXPOSE 8080

CMD ["java", "-jar", "kafka-tester.jar"]
