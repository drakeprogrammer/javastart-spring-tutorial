#!/usr/bin/env bash

./remove-mysql-continer.sh

docker run --name spring-framework-mysql-db -p 3306:3306  -d spring-framework-mysql:20190210