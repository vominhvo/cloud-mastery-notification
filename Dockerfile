FROM azul/zulu-openjdk-alpine:17

ARG ENVIRONMENT
ARG APP_NAME

ENV ENVIRONMENT ${ENVIRONMENT}
ENV MICROSERVICE ${MICROSERVICE}

ADD artifact/${APP_NAME}*.jar /opt/app.jar

EXPOSE 8080

CMD java -jar /opt/app.jar