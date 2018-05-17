FROM ubuntu:16.04
MAINTAINER SaiRaghavArram

RUN mkdir /memoryloadgenerator

COPY memoryloadgenerator/target/memoryloadgenerator.war memoryloadgenerator/



