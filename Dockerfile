FROM alpine:3.10

RUN addgroup -g 1000 node
RUN adduser -u 1000 -G node -s /bin/sh -D node

RUN apk add --update openjdk8
RUN apk add --update maven
RUN apk add --update npm
RUN apk add --update yarn

COPY . /High5
WORKDIR /High5/restful-web-services

COPY .m2 /root/.m2
RUN mvn verify

WORKDIR ../frontend/todo-app

ENV CI=true

RUN npm ci
RUN npm run build
RUN npm run test

RUN npm prune --production

EXPOSE 4200
EXPOSE 8080

USER node

ENTRYPOINT /bin/sh /High5/docker-entrypoint.sh