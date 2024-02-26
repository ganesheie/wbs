FROM tomcat:jre21

# Copy your modified server.xml into the Tomcat configuration directory
COPY server.xml /usr/local/tomcat/conf/

# Download MySQL JDBC driver JAR file and copy it into Tomcat lib directory
# You can replace the URL with the appropriate version of the MySQL JDBC driver
COPY mysql-connector-j-8.3.0.jar /usr/local/tomcat/lib/
COPY jnditest.jsp /usr/local/tomcat/webapps.dist/ROOT/
RUN cp -Rf /usr/local/tomcat/webapps.dist/* /usr/local/tomcat/webapps/
CMD ["catalina.sh","run"]
