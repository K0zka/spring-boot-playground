# spring-boot-playground
Playground for spring boot apps

## Load-balancer config with haproxy

```
frontend spring-lb
        bind 0.0.0.0:80
        default_backend spring-gateways

backend spring-gateways
        mode http
        option httpclose
        # redispatch to other node if fails
        option redispatch
        balance roundrobin
        server d1i1 spring-d1i1:9000 check
        server d1i2 spring-d1i2:9000 check
        server d2i1 spring-d2i1:9000 check
        server d2i2 spring-d2i2:9000 check

```


