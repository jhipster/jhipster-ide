#!/bin/bash
# Sample Usage: deleteExistingRepoArtifacts.sh username apikey owner repo package version
###############################################
API=https://api.bintray.com
BINTRAY_USER=$1
BINTRAY_API_KEY=$2
BINTRAY_OWNER=$3
BINTRAY_REPO=$4
PCK_NAME=$5
PCK_VERSION=$6
###############################################

function main(){
  deleteMavenArtifacts
}

function deleteMavenArtifacts() {
  echo "${BINTRAY_USER}"
  echo "${BINTRAY_OWNER}"
  echo "${BINTRAY_REPO}"
  echo "${PCK_NAME}"
  echo "${PCK_VERSION}"

  echo "Delete existing maven repo version $PCK_VERSION"
  curl -X DELETE -u ${BINTRAY_USER}:${BINTRAY_API_KEY} "https://api.bintray.com/packages/${BINTRAY_OWNER}/${BINTRAY_REPO}/${PCK_NAME}/versions/$PCK_VERSION" -H "content-type:application/json" 

  echo "Create new maven repo version $PCK_VERSION"
  curl -X POST -u ${BINTRAY_USER}:${BINTRAY_API_KEY} "https://api.bintray.com/packages/${BINTRAY_OWNER}/${BINTRAY_REPO}/${PCK_NAME}/versions" -d '{"name": "'$PCK_VERSION'", "desc": "Release '$PCK_VERSION'"}' -H "content-type:application/json" 
  echo ""
}

main "$@"