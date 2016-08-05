#!/bin/sh
TOMCAT_HOME=/Applications/apache-tomcat-9.0.0.M9
mvn clean package; rm -r #{TOMCAT_HOME}/webapps/kafka-consumer*; cp target/kafka-consumer.war ${TOMCAT_HOME}/webapps/.
