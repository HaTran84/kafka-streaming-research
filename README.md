# Demo for Cloud Kafka streaming

## How to development
### Start Kafka cluster

Open docker-compose.yml, change the IP to your current IP for brokers at `KAFKA_CFG_ADVERTISED_LISTENERS`

Start your clusters with command:
```shell
docker-compose up -d
```

### Kafka Web UI
```text
http://localhost:9000
```

### Mongo Express
```text
http://localhost:9001
```

### Run Producer application and streaming application
Remember to edit the application.yml with broker IPs.
