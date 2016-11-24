#!/bin/bash
#Sample Usage: upload.sh username apikey owner repo package version pathToP2Repo
API=https://api.bintray.com
BINTRAY_USER=$1
BINTRAY_API_KEY=$2
BINTRAY_OWNER=$3
BINTRAY_REPO=$4
PCK_NAME=$5
PCK_VERSION=$6
PATH_TO_REPOSITORY=$7
function main(){
deploy_updatesite
}
function deploy_updatesite() {
echo "${BINTRAY_USER}"
echo "${BINTRAY_OWNER}"
echo "${BINTRAY_REPO}"
echo "${PCK_NAME}"
echo "${PCK_VERSION}"
echo "${PATH_TO_REPOSITORY}"
#if [ ! -z "$PATH_TO_REPOSITORY" ]; then
   cd $PATH_TO_REPOSITORY
#fi
FILES=./*
BINARYDIR=./binary/*
PLUGINDIR=./plugins/*
FEATUREDIR=./features/*
for f in $FILES;
do
if [ ! -d $f ]; then
  if [[ "$f" == *content.jar ]] || [[ "$f" == *artifacts.jar ]] || [[ "$f" == p2.index ]] 
  then
  export ff=$(echo $f | cut -c3-1000)
  echo "Processing $ff file..."
#    echo "Uploading p2 metadata file directly to the repository"
#    curl -X PUT -T $f -u ${BINTRAY_USER}:${BINTRAY_API_KEY} https://api.bintray.com/content/${BINTRAY_OWNER}/${BINTRAY_REPO}/$f;publish=0
#  else 
    curl -X PUT -T $ff -u ${BINTRAY_USER}:${BINTRAY_API_KEY} https://api.bintray.com/content/${BINTRAY_OWNER}/${BINTRAY_REPO}/${PCK_NAME}/${PCK_VERSION}/$ff;publish=0
  fi
#  echo ""
fi
done
for f in $FEATUREDIR;
do
  export ff=$(echo $f | cut -c3-1000)
  echo "Processing feature: $ff file..."
  curl -X PUT -T $ff -u ${BINTRAY_USER}:${BINTRAY_API_KEY} https://api.bintray.com/content/${BINTRAY_OWNER}/${BINTRAY_REPO}/${PCK_NAME}/${PCK_VERSION}/$ff;publish=0
#  echo ""
done
for f in $PLUGINDIR;
do
   # take action on each file. $f store current file name
  export ff=$(echo $f | cut -c3-1000)
  echo "Processing plugin: $ff file..."
  curl -X PUT -T $ff -u ${BINTRAY_USER}:${BINTRAY_API_KEY} https://api.bintray.com/content/${BINTRAY_OWNER}/${BINTRAY_REPO}/${PCK_NAME}/${PCK_VERSION}/$ff;publish=0
#  echo ""
done
echo "Publishing the new version"
curl -X POST -u ${BINTRAY_USER}:${BINTRAY_API_KEY} https://api.bintray.com/content/${BINTRAY_OWNER}/${BINTRAY_REPO}/${PCK_NAME}/${PCK_VERSION}/publish -d "{ \"discard\": \"false\" }"
}
main "$@"

