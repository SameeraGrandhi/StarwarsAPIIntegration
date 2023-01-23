#!/bin/bash

if [ -f pid.file ]
then
	kill $(cat pid.file)
	rm -rf pid.file
	echo "Successfully stopped server"
else
  echo "Cannot find relevant pid file, seems like your server is not started yet"
fi
