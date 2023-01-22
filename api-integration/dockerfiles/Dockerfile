FROM maven:3.6.3-jdk-11 as base
MAINTAINER sameeragrandhi

WORKDIR /app

COPY . /app

RUN mvn clean install

FROM adoptopenjdk/openjdk11:alpine-jre

ARG JAR_FILE=starwars.jar

WORKDIR /app/artifacts
# Copy the starwars.jar from the maven stage to the Workdir directory of the current stage.
COPY --from=base /app/target/api-integration-1.0.jar /app/artifacts/starwars.jar

ENTRYPOINT ["java","-jar","starwars.jar"]
