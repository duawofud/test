package com.example.kafka.Repository;

import com.example.kafka.domain.Member;

public interface KafkaRepository {

	void kafkaProducer(Member member);
	String KafkaConsumer(String userName);
	
}
