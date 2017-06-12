#-----------------------------------------------------------------------------------------------------
# API Gateway
#-----------------------------------------------------------------------------------------------------
FROM openjdk:8u121-jdk-alpine

MAINTAINER Manoj Pathak <manojpathak.s@gmail.com>

# Keep consistent with build.gradle
ENV APP_JAR_NAME api-gateway
ENV APP_JAR_VERSION 0.0.1

# Install curl
RUN apk --update add curl && \
    rm -rf /var/cache/apk/*

RUN mkdir /app

ADD ${APP_JAR_NAME}-${APP_JAR_VERSION}.jar /app/ 
ADD run.sh /app/
RUN chmod +x /app/run.sh

WORKDIR /app

EXPOSE 8765

ENTRYPOINT ["/bin/bash", "-c"]
CMD ["/app/run.sh"]