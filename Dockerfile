# Use an official Tomcat image as the base
FROM tomcat:9.0-jdk11-openjdk

# Copy the WAR file to the webapps directory of Tomcat
COPY target/LibraryManager.war /Users/fernandobicalho/Documents/apache-tomcat-9.0.91/webapps/

# Expose the default Tomcat port
EXPOSE 8081

# Run Tomcat server
CMD ["catalina.sh", "run"]