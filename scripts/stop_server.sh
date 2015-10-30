#!/bin/bash

# Stop web server
tomcat_running=`pgrep tomcat`
if [[ -n  $tomcat_running ]]; then
    service tomcat8 stop
fi

httpd_running=`pgrep httpd`
if [[ -n  $httpd_running ]]; then
    service httpd stop
fi

# Remove existing html pages
#rm -rf /usr/share/tomcat8/webapps/hello.war /usr/share/tomcat8/webapps/hello*