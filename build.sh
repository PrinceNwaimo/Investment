#!/bin/bash

# Navigate to the directory containing the pom.xml file
cd "$(dirname "$0")/Investment"

# Clean and package the project using Maven
mvn clean package

# Check if the build was successful
if [ $? -eq 0 ]; then
  echo "Build succeeded!"
else
  echo "Build failed!"
  exit 1
fi

