#!/bin/sh
set -e

BUILD_DIR=$1
BUILD_TAG=$2

BT_USER=$3
BT_APIKEY=$4

RELEASE=$5
VERSION=$6

OWNER=jhipster
PACKAGE=jhipster-ide
#PRODUCT=`ls -1 $BUILD_DIR/releng/target/io.github.jhipster-ide-$VERSION*.zip`
PRODUCT=$BUILD_DIR/releng/target/io.github.jhipster-ide-$VERSION*.zip

echo "Folder: $BUILD_DIR tag: $BUILD_TAG release: $RELEASE version: $VERSION product: $PRODUCT"

cd $BUILD_DIR/releng && ./mvnw clean package -Pproduct
cd $BUILD_DIR/jdl/io.github.jhipster.jdl.vscode && npm install && vsce package

#cd $BUILD_DIR/releng/target
#echo "Upload and publish $PRODUCT to bintray https://api.bintray.com/content/$OWNER/$PACKAGE/$RELEASE/$VERSION from folder $PWD"
#curl -X PUT -T $PRODUCT -H X-Bintray-Explode:1 -H X-Bintray-Publish:1 -H X-Bintray-Override:1 -u$BT_USER:$BT_APIKEY https://api.bintray.com/content/$OWNER/$PACKAGE/$RELEASE/$VERSION
