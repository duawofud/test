package com.example.kafka.service;

import java.io.IOException;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer2 {
    @KafkaListener(topics = "exam-topic", groupId = "foo")
    public void consume(String message) throws IOException {
    	System.out.println("KafkaConsumer2:"+message);
    }
}