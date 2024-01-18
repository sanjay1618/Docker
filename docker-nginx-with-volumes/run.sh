#!/bin/bash
sudo docker container run --rm -d -v $(pwd):/usr/share/nginx/html -p 8080:80 sanjay1606/my-website:latest

#Command to run a container with a volume being mounted to the container to propagate changes.