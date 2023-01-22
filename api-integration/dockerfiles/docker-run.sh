#!/bin/sh

docker build --tag=starwars:latest .
docker run -p8080:8080 starwars:latest