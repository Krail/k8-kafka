#!/bin/sh

# Create Zookeeper
kubectl create -f zookeeper-svc.yaml
kubectl create -f zookeeper-rc.yaml

# Create Kafka
kubectl create -f kafka-svc.yaml
kubectl create -f kafka-0-rc.yaml
#kubectl create -f kafka-1-rc.yaml
#kubectl create -f kafka-2-rc.yaml

# Create Consumer
kubectl create -f consumer-svc.yaml
kubectl create -f consumer-rc.yaml

# Create Producer
kubectl create -f producer-svc.yaml
kubectl create -f producer-rc.yaml

# Create a secret with an SSL certificate and a key
kubectl create -f kafka-secret.yaml

# Create an Ingress Resource
kubectl create -f kafka-ingress.yaml

# Create an NGINX Ingress Controller
kubectl create -f nginx-ingress-rc.yaml


# The Controller container exposes ports 80, 443 (and 8080 for NGINX Plus ) on the host it is running on.
# Curl https://<NodeIP>:443/tea
# and  https://<NodeIP>:443/coffee
