FROM anapsix/alpine-java

MAINTAINER Krail

RUN apk add --update unzip wget curl docker jq coreutils

ADD ../common/kafka_2.11-0.10.0.0 /kafka

EXPOSE 80 443 2181 8080 9092

CMD ["/kafka/bin/zookeeper-server-start.sh","/kafka/config/zookeeper.properties"]

