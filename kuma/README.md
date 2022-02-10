# Kuma

# Download
```
$ wget https://download.konghq.com/mesh-alpine/kuma-1.4.1-ubuntu-amd64.tar.gz

$ tar xvzf kuma-*.tar.gz
```

# Run
```
$ sudo cp kuma-1.4.1/bin/kumactl /usr/local/bin/kumactl

$ kumactl install control-plane | kubectl apply -f -
```

# Metrics
```
$ kumactl install metrics | kubectl apply -f -
```

# Kong (Ingress)

## Install
```
$ kubectl apply -f https://raw.githubusercontent.com/Kong/kubernetes-ingress-controller/master/deploy/single/all-in-one-dbless.yaml
```

## Add Label to the Namespace
```
$ kubectl annotate namespace kong kuma.io/sidecar-injection=enabled
```

## Force trigger sidecar
```
$ kubectl delete pod --all -n kong
```

## Adding an Ingress Rule
```
$ echo "apiVersion: networking.k8s.io/v1
kind: Ingress
metadata:
  name: demo-ingress
  namespace: kuma-demo
  annotations:
    konghq.com/strip-path: 'true'
spec:
  ingressClassName: kong
  rules:
    - http:
        paths:
          - path: /
            pathType: Prefix
            backend:
              service:
                name: frontend
                port: 
                  number: 8080" | kubectl apply -f -
```