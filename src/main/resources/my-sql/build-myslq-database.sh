#!/usr/bin/env bash
set -e

if [ $(docker images | grep 'spring-framework-mysql' | wc -l) -le 0 ];
then
	echo 'Image spring-framework-mysql does not exists'
else
	./remove-mysql-continer.sh
	docker rmi $(docker images |grep 'spring-framework-mysql')
	echo 'Removed image spring-framework-mysql'
fi

docker build -t spring-framework-mysql:$(date +%Y%m%d) -f Dockerfile ../ --no-cache