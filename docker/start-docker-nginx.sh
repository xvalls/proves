#!/bin/sh
# parameters
#   $1 : container name

echo "Starting container nginx$1"
docker run --name nginx$1 -d -p 8180:80 -v/Users/xaviervalls/feina/nginx/html:/usr/share/nginx/html nginx
echo Container started.
