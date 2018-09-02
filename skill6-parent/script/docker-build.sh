#!/usr/bin/env bash
cd ..
mvn clean package docker:build -DskipTests