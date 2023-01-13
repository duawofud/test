package com.example.kafka.Repository;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.kafka.domain.Member;

@Service
public class KafkaMembeRepository implements KafkaRepository {
	

    private static final String TOPIC = "provider";
    private final JdbcTemplate jdbcTemplate;
    
    @Autowired
    private final KafkaTemplate<String, String> kafkaTemplate;
    
    
    public KafkaMembeRepository(KafkaTemplate<String, String> kafkaTemplate , DataSource dataSource) {
    	this.kafkaTemplate = kafkaTemplate;
    	this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
	
	@Override
	@KafkaListener(topics = TOPIC, groupId = "foo")
	public String KafkaConsumer(String userName) {
		// TODO Auto-generated method stub
		System.out.println("----------------------KafkaConsumer KafkaMembeRepository : "+userName);
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("name", userName);
		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
//		System.out.println("[KafkaConsumer userName]--------------------------------"+userName);
//		System.out.println("[KafkaConsumer key]--------------------------------"+key);
		return userName;
	}

	@Override
	public void kafkaProducer(Member member) {
		// TODO Auto-generated method stub
		String userName = member.getName();
		this.kafkaTemplate.send(TOPIC, userName);
	}

}
