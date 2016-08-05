#!/bin/sh

# Create either an NGINX or an NGINX Plus Ingress Controller:
kubectl delete -f nginx-ingress-rc.yaml

# Create an Ingress Resource:
kubectl delete -f cafe-ingress.yaml

# Create a secret with an SSL certificate and a key:
kubectl delete -f cafe-secret.yaml

# Create an NGINX Ingress Controller
kubectl delete -f nginx-ingress-rc.yaml

# Create an NGINX Ingress Controller
kubectl delete -f nginx-ingress-rc.yaml

# Create an Ingress Resource
kubectl delete -f cafe-ingress.yaml

# Create a secret with an SSL certificate and a key
kubectl delete -f cafe-secret.yaml

# Create Producer
kubectl delete -f producer-rc.yaml
kubectl delete -f producer-svc.yaml

# Create Consumer
kubectl delete -f consumer-rc.yaml
kubectl delete -f consumer-svc.yaml

# Create Kafka
kubectl delete -f kafka-0-rc.yaml
kubectl delete -f kafka-1-rc.yaml
kubectl delete -f kafka-2-rc.yaml
kubectl delete -f kafka-svc.yaml

# Create Zookeeper
kubectl delete -f zookeeper-rc.yaml
kubectl delete -f zookeeper-svc.yaml

