Tomcat HelloWorld Demo
=====================

Purpose
--
Provides a simple HelloWorld app to be deployed to tomcat that uses maven for build.

Provides a simple Employee app with a REST API to also be deployed to tomcat that uses maven to build.

#### Interacting with the EmployeeApi
```bash
# list all contacts, returned in JSON format
curl -H "Accept:application/json" http://<hostname>/employee/rest/contacts

# list all contacts, returned in XML format
curl http://<hostname>/employee/rest/contacts

# create/update employee contact in JSON format
curl -X PUT -H "Content-Type:application/json" -H "Accept:application/json" --data '{
	"id": "fsmith",
	"name": "Fred Smith"
	"address": [
		{ "city": "Melbourne", "street": "Bourke Street"} 
	]
    }' http://<hostname>/employee/rest/contacts/fsmith
    
# create/update employee contact in XML format
curl -X PUT -H "Content-type:application/xml" --data "<contact>
	<id>fsmith</id>
	<name>Fred Smith</name>
	<address>
		<city>Melbourne</city>
		<street>Bourke Street</street>
	</address>
</contact>" http://<hostname>/employee/rest/contacts/fsmith

# list specific employee contact, in JSON format
curl -H "Accept:application/json" http://<hostname>/employee/rest/contacts/fsmith
```
