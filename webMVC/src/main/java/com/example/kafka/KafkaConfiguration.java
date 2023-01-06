package com.example.kafka;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.example.kafka.Repository.JdbcTemplateMemberRepository;
import com.example.kafka.Repository.KafkaMembeRepository;
import com.example.kafka.Repository.KafkaRepository;
import com.example.kafka.Repository.MemberRepository;
import com.example.kafka.service.KafkaService;
import com.example.kafka.service.MemberService;

@Configuration
public class KafkaConfiguration {

	//application.yml 디렉토리 properties load
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;
    
    /**
     * dataSource Configuration
     */
	
	// JPAConfiguration -> MemberService -> MemberRepository
	// Spring JPA Template ( JAVA JPA )
	
	private final DataSource dataSource;
	
	@Autowired // springboot 에서 기본으로 지원함 > datasource 는 초기로딩 시 생성
	public KafkaConfiguration(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	/**
	 * service Implement Configuration
	 * @return
	 */
	
	@Bean
	public MemberService memberService() {
		return new MemberService(memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository() {
//		return new MemoryMemberRepository();
		return new JdbcTemplateMemberRepository(dataSource);
	}

	/**
	 * kafka Configuration
	 * @return
	 */
	

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }
    
    @Bean
    public ProducerFactory<String, String> producerFactory() {

        Map<String,Object> configs = new HashMap<>();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory(configs);
    }
    
 
	@Bean
	public KafkaService kafkaService() {
		return new KafkaService(kafkaRepository());
	}
	
	@Bean
	public KafkaRepository kafkaRepository() {
//		return new MemoryMemberRepository();
		return new KafkaMembeRepository(new KafkaTemplate<>(producerFactory()), dataSource);
	}    
//	@Bean
//	public TimeTraceAop timetraceAop() {
//		return new TimeTraceAop();
//	}
    
}