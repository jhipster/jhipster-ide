#!/bin/sh
set -e

BUILD_DIR=$1
BUILD_TAG=$2

echo $BUILD_DIR
echo $BUILD_TAG

cd $BUILD_DIR && ./mvnw clean package -Pproduct
cd $BUILD_DIR/jdl/io.github.jhipster.jdl.vscode && npm install && vsce package
