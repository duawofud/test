package com.example.kafka.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.kafka.Repository.KafkaRepository;
import com.example.kafka.domain.Member;

public class KafkaService {

	private final KafkaRepository kafkaRepo;
	
	@Autowired
	public KafkaService (KafkaRepository kafkaRepo) {
		this.kafkaRepo = kafkaRepo;
	}
	
	public void sendMessage(Member member) {
		kafkaRepo.kafkaProducer(member);
	}
	
}
