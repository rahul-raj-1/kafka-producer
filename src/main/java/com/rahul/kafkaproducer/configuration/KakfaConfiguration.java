package com.rahul.kafkaproducer.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.rahul.kafkaproducer.entity.User;

@Configuration
@EnableKafka
public class KakfaConfiguration {
	
	
	@Value("${spring.kafka.producer.bootstrap-servers}")
    private String bootstrapServers;
	
	@Value("${spring.kafka.producer.properties.acks}")
    private String acks;
	
	@Value("${spring.kafka.producer.properties.retry.backoff.ms}")
    private String retryBackOffMsConfig;
	
	@Value("${spring.kafka.producer.properties.retries}")
    private String retries;

	@Bean
	public ProducerFactory<String, String> producerFactory() {
		Map<String, Object> config = new HashMap<>();

		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		config.put(ProducerConfig.ACKS_CONFIG, acks);
		config.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, retryBackOffMsConfig);
		config.put(ProducerConfig.RETRIES_CONFIG, retries);


		return new DefaultKafkaProducerFactory<>(config);
	}

	@Bean
	public KafkaTemplate<String, String> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}

}
