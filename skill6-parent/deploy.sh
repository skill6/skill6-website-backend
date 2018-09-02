#!/usr/bin/env bash
mvn clean package docker:build -DskipTests
cd docker
docker-compose down
docker-compose up --build -d