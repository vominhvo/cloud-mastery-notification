
# Stage 1: Build source to the artifact (.JAR)
FROM maven:3.9.8-eclipse-temurin-17-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM azul/zulu-openjdk-alpine:17

ARG ENVIRONMENT
ARG APP_NAME
ARG APP_PORT=8080

ENV ENVIRONMENT ${ENVIRONMENT}
ENV APP_NAME ${APP_NAME}
ENV SERVER_PORT ${APP_PORT}

COPY --from=build /app/target/*.jar /opt/app.jar

EXPOSE ${APP_PORT}

#CMD java -jar /opt/app.jar
ENTRYPOINT ["java", "-jar", "/opt/app.jar"]