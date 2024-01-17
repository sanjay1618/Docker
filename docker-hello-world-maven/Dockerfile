#This will create an docker image which is maven based one and it has some junit5 test cases related to String class.
FROM maven:3.6.3 AS build
WORKDIR /app
#Copies the pom.xml file from my local system.
COPY pom.xml /app/pom.xml
WORKDIR /app
COPY src/ ./src
#This runs maven goals.
RUN mvn clean install
CMD ["mvn", "test"]





