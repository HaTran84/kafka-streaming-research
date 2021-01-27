package me.vlqhai.kafka.mongodbsink;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(org.springframework.cloud.stream.app.mongodb.sink.MongodbSinkConfiguration.class)
public class MongodbSinkApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbSinkApplication.class, args);
    }

}
