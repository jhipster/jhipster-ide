#!/bin/bash
for i in $1/*.jar
  do
	jarsigner -keystore ../keystore -storepass “changeit” -verbose -keypass $3 $i $2
  done
 