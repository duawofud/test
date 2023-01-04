package com.example.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer2 {
    private static final String TOPIC = "exam-topic";

    @Autowired
    private final KafkaTemplate<String, String> kafkaTemplate;
    
    public KafkaProducer2(KafkaTemplate<String, String> kafkaTemplate) {
    	System.out.println("kafkaTemplate getDefaultTopic:---------------"+kafkaTemplate.getDefaultTopic());
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendMessage(String message) {
		System.out.println("kafkaTemplate:---------------"+message);
        this.kafkaTemplate.send(TOPIC, message);
    }
}