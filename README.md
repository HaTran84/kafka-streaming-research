# Demo for Cloud Kafka streaming

## How to development
### Start Kafka cluster

Open docker-compose.yml, change the IP to your current IP for brokers at `KAFKA_CFG_ADVERTISED_LISTENERS`

Start your clusters with command:
```shell
docker-compose up -d
```

### Run Kafdrop - web UI of Kafka
Change the IP of your kafka cluster in the following command and run it.
```shell
docker run -d --rm -p 9000:9000 \
    -e KAFKA_BROKERCONNECT=172.19.23.236:9092,172.19.23.236:9093,172.19.23.236:9094 \
    -e JVM_OPTS="-Xms32M -Xmx64M" \
    -e SERVER_SERVLET_CONTEXTPATH="/" \
    obsidiandynamics/kafdrop
```

### Run Producer application and streaming application
Remember to edit the application.yml with broker IPs.
