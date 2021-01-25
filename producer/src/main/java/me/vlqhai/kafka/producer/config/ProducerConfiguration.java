package me.vlqhai.kafka.producer.config;

import com.github.javafaker.Faker;
import me.vlqhai.kafka.dto.model.ExternalUserData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.function.Supplier;

@Configuration
public class ProducerConfiguration {
    private static final Logger logger = LoggerFactory.getLogger(ProducerConfiguration.class);

    private final Faker faker = new Faker(new Locale("vi"));

    @Bean
    public Supplier<ExternalUserData> externalUserProducer() {
        return () -> {
            logger.info("Producing new external user data");
            return new ExternalUserData(
                    faker.number().randomNumber(12, false),
                    "CRM",
                    faker.name().fullName()
            );
        };
    }
}
