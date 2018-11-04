#!/bin/bash
# parameters
#   $1 : docker image name
#   $2 : container name
#   $3 : local port
#   $4 : container port
#   $5 : detach process Y/N

dockerImage=$1
dockerContainerName=$dockerImage$2
portHost=$3
portContainer=$4


# Test if the param number is greater than 4, we have a detach parameter
if [  $# -gt 4 ]
then
  detachContainer=$5
else
  detachContainer=KK 
fi

if [ $detachContainer == 'Y' ]
then
     containerDetach=-d
     echo Docker container will be executed in detach mode
fi

echo "Starting container $dockerContainerName"
docker run --name $dockerContainerName $containerDetach -p $portHost:$portContainer $dockerImage
echo Container started.
