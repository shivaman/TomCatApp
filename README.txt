A simple HelloWorld app to be deployed to tomcat. Uses maven for build.

http://grahamlyons.com/article/hello-world-war-using-tomcat-and-maven-on-ubuntu



 * In the hello directory in the workspace run the following commands: - mvn package

This compiles the Java classes and puts them into a WAR file.

 * sudo cp target/hello.war /var/lib/tomcat7/webapps/
 * curl -D - http://127.0.0.1:8080/hello/
HTTP/1.1 200 OK
Server: Apache-Coyote/1.1
Content-Length: 11
Date: Tue, 18 Jun 2013 07:12:13 GMT

Hello World

