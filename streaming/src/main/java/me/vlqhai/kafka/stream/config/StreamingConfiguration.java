package me.vlqhai.kafka.stream.config;

import me.vlqhai.kafka.dto.model.ExternalUserData;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Predicate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;


@Configuration
public class StreamingConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(StreamingConfiguration.class);

    @Bean
    @SuppressWarnings("unchecked")
    public Function<KStream<String, ExternalUserData>, KStream<Long, ExternalUserData>[]> evenOddProcessor() {
        Predicate<Long, ExternalUserData> evenData = (k, v) -> k % 2 == 0;
        Predicate<Long, ExternalUserData> oddData = (k, v) -> k % 2 != 0;
        return input -> input
                .peek((k, v) -> logger.info("Receiving key: {} - refId: {} - name: {}", k, v.getRefId(), v.getName()))
                .map((k, v) -> new KeyValue<Long, ExternalUserData>(v.getRefId(), v))
                .branch(evenData, oddData);
    }
}
