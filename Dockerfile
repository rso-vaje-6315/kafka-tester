FROM openjdk:11-jre-slim

ENV JAVA_ENV=PRODUCTION
ENV KUMULUZEE_ENV_NAME=prod
ENV KUMULUZEE_ENV_PROD=true
ENV KUMULUZEE_DATASOURCES0_CONNECTIONURL=jdbc:postgresql://localhost:5432/kafka-tester
ENV KUMULUZEE_DATASOURCES0_USERNAME=not_set
ENV KUMULUZEE_DATASOURCES0_PASSWORD=not_set
ENV KUMULUZEE_LOGS_LOGGERS0_LEVEL=INFO

RUN mkdir /app
WORKDIR /app

ADD ./api/v1/target/kafka-tester.jar /app

EXPOSE 8080

CMD ["java", "-jar", "kafka-tester.jar"]