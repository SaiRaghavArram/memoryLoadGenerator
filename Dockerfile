FROM ubuntu:16.04
MAINTAINER SaiRaghavArram

WORKDIR /build/memoryloadgenerator

RUN mkdir memoryloadgenerator

COPY target/memoryloadgenerator.war memoryloadgenerator/



