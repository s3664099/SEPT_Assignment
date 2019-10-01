#!/bin/sh

cd ../../restful-web-services/target/
java -jar restful-web-services-0.0.1-SNAPSHOT.jar &
sleep 30
cd ../../frontend/todo-app/
npm start