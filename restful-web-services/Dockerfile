# Sourced from:
# 1 -  https://www.callicoder.com/spring-boot-docker-example/?fbclid=IwAR06fivnk-eS2abGSypW2igiu6Af-O20MS6YYykfs_Sl2SLBYIr0YTiaUFo
# 2 - https://www.callicoder.com/spring-boot-mysql-react-docker-compose-example/?fbclid=IwAR2-KOlTM9VZDZVGvJRQ2SukruH3pdHIn7IYeoJVONqc3Dy3ZxsFacClV5c

# Change all controller crossorigin to your front-end static ip on kubernetes like this"http://1.1.1.1:4200"
# Start with a base image containing Java runtime
FROM openjdk:8-jdk-alpine as build

RUN mkdir -p /projectname/server
WORKDIR /projectname/server

COPY pom.xml .
COPY src src

RUN mkdir -p /target
COPY target/restful-web-services-0.0.1-SNAPSHOT.jar target/
RUN mkdir -p target/dependency && (cd target/dependency; jar -xf ../*.jar)

# Some More Stuff
FROM openjdk:8-jre-alpine

ARG DEPENDENCY=/projectname/server/target/dependency

COPY --from=build ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY --from=build ${DEPENDENCY}/META-INF /app/META-INF
COPY --from=build ${DEPENDENCY}/BOOT-INF/classes /app

# Run the jar file 
ENTRYPOINT ["java","-cp","app:app/lib/*","com.sept.rest.webservices.restfulwebservices.RestfulWebServicesApplication"]