#!/bin/bash

echo "Running Maven Build"

mvn clean install

echo "Starting spring boot server"

if [ -f pid.file ]
then
  
	echo "Found a pid file, looks like server is already up, please run devstop.sh first!!"

else
	current_timestamp=$(date | tr -d '[:space:]')
	echo $current_timestamp
	logfile="log_${current_timestamp}"

	mvn spring-boot:run > /tmp/${logfile}.txt 2>&1 &

	echo $! > pid.file
	echo "Logs located at /tmp/${logfile}.txt"
fi
