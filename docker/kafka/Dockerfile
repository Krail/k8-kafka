FROM anapsix/alpine-java

MAINTAINER Krail

RUN apk add --update unzip wget curl docker jq coreutils

ENV KAFKA_VERSION="0.10.0.0" SCALA_VERSION="2.11"

ADD ../common/kafka_2.11-0.10.0.0 /kafka

EXPOSE 80 443 2181 8080 9092

#CMD ["/kafka/bin/kafka-server-start.sh", "/kafka/config/server-0.properties", "--override", "zookeeper.connect=${ZOOKEEPER_SVC_SERVICE_HOST}:${ZOOKEEPER_SVC_SERVICE_PORT}"]
CMD ["/kafka/bin/kafka-server-start.sh", "/kafka/config/server-0.properties", "--override", "zookeeper.connect=10.3.0.198:2181"]

