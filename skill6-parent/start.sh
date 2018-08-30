#!/usr/bin/env bash
mvn clean package docker:build -DskipTests
docker-compose up --build -d