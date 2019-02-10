#!/usr/bin/env bash

if [ $(docker ps -a | grep 'spring-framework-mysql' | wc -l) -le 0 ];
then
	echo 'Container spring-framework-mysql with mysql database does not exists'
else
	echo 'Container spring-framework-mysql with mysql database exists'
	docker stop spring-framework-mysql-db
	docker wait spring-framework-mysql-db
	docker rm spring-framework-mysql-db
fi

