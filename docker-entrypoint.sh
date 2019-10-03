#!/bin/sh

cd ../../restful-web-services/target/
java -jar restful-web-services-0.0.1-SNAPSHOT.jar &
sleep 30
export PORT=4200
cd ../../frontend/todo-app/
npm start & 

NPMPID = `pidof npm`

while `ps | grep -q $NPMPID`; do
    sleep 15
done

