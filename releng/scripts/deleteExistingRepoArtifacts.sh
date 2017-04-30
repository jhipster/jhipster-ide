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

#  echo "Create new maven repo version $PCK_VERSION"
#  curl -X POST -u ${BINTRAY_USER}:${BINTRAY_API_KEY} "https://api.bintray.com/packages/${BINTRAY_OWNER}/${BINTRAY_REPO}/${PCK_NAME}/versions" -d '{"name": "'$PCK_VERSION'", "desc": "Release '$PCK_VERSION'"}' -H "content-type:application/json" 
  echo ""
  echo "Done!"
  curl -X DELETE -ucolameo:6562b8537c82dd3fed9960e20de8d7b61e3ea583 https://api.bintray.com/content/colameo/test/1.0/1.2.0/
  curl -X PUT -T ./io.github.jhipster-ide-1.2.0-SNAPSHOT.zip -H X-Bintray-Explode:1 -ucolameo:6562b8537c82dd3fed9960e20de8d7b61e3ea583 https://api.bintray.com/content/colameo/test/1.0/1.2.0/

  curl -X PUT -T ./_test3.zip -H X-Bintray-Explode:1 -H X-Bintray-Publish:1 -H X-Bintray-Override:1 -ucolameo:6562b8537c82dd3fed9960e20de8d7b61e3ea583 https://api.bintray.com/content/colameo/test/1.0/1.1.0/
 
  curl --request PUT \
  --upload-file "${file_absolute_path}" \
  --user ${BINTRAY_USER}:${BINTRAY_API_KEY} \
  "${API}/content/${BINTRAY_OWNER}/${repo}/${file_relative_path};bt_package=${package};bt_version=${version};publish=1;override=1;explode=0"

}

main "$@"