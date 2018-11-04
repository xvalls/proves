#!/bin/sh

# Start a Redis container

# parameters
#   $1 : docker image number

portLocal=6379
portContainer=6379

./start-docker.sh redis $1 $portLocal $portContainer
:
