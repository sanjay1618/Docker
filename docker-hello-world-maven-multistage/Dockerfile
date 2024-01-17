#This is a multi-stage build of docker image.From the first intermediary build it creates a jar of the pom file
FROM maven:3.6.3 AS build
WORKDIR /app
#Copies the pom.xml file from my local system.
COPY pom.xml /app/pom.xml
WORKDIR /app
COPY src/ ./src
#This runs maven goals.
RUN mvn clean install 
# This is the final runtime image. 

FROM openjdk:8
#This copies the generated jar file from the previous intermediary stage.
COPY --from=build /app/target/junitDemo-1.0-SNAPSHOT.jar /app/
WORKDIR /app/
ENTRYPOINT ["java"]
CMD ["-jar", "junitDemo-1.0-SNAPSHOT.jar"]

