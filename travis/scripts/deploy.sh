#!/bin/bash
set -e

BUILD_DIR=$1
BUILD_TYPE=$2
BUILD_TAG=$3

echo $BUILD_DIR
echo $BUILD_TYPE
echo $BUILD_TAG
cd $BUILD_DIR

java -version
./mvnw -version
node --version
