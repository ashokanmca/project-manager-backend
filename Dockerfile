# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine

# Add Maintainer Info
MAINTAINER Ashokan K <ashokanmca@gmail.com>

# Add a volume pointing to /tmp
VOLUME /tmp

##ADD /dev/./urandom/fsd_project_manager.mv.db /tmp/fsd_project_manager.mv.db

# Make port 8080 available to the world outside this container
EXPOSE 8080

# The application's jar file
ARG JAR_FILE=target/project-manager-backend-0.0.1-SNAPSHOT.war

# Add the application's jar to the container
ADD ${JAR_FILE} project-manager-backend.war

# Run the jar file 
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/project-manager-backend.war"]

