#This is a multi-stage build of docker image.From the first intermediary build it creates a jar of the pom file
FROM maven:3.6.3 AS build
WORKDIR /app
COPY pom.xml /app/pom.xml
WORKDIR /app
COPY src/ ./src
RUN mvn clean install
CMD ["mvn", "test"]





