# Use an official Tomcat image as the base
FROM tomcat:9.0.75-jdk17-temurin

# Remove the default ROOT web app from Tomcat
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy your Spring Boot WAR file to the webapps directory as ROOT.war
COPY target/library-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/ROOT.war

# Expose the default Tomcat port
EXPOSE 8085

# Run Tomcat server
CMD ["catalina.sh", "run"]
