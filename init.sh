#!/bin/sh
mongoimport -d testdb -c states --file "/docker-entrypoint-initdb.d/people.csv" --type csv --fields name,age,state