#We are using the jdk version 8 as the base image for the build image.
FROM openjdk:8

#Setting the hello as the working directory.
WORKDIR /usr/src/hello

#Copying the HelloWorld.java program into the image
COPY HelloWorld.java ./

#Running a linux command to complile the source code.
RUN javac HelloWorld.java

#Running the java program after the container has been started.
CMD ["java", "HelloWorld"]