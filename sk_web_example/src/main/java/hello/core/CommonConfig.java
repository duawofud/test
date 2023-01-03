package hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.common.LoggingRepo;
import hello.core.common.LoggingRepoImpl;
import hello.core.common.LoggingService;
import hello.core.common.LoggingServiceImpl;
import hello.core.common.TimeTraceAop;

@Configuration
public class CommonConfig {

	@Bean
	public LoggingService loggingService() {
		return new LoggingServiceImpl(loggingRepo());
	}

	@Bean
	public LoggingRepo loggingRepo() {
		return new LoggingRepoImpl();
	}
	
	@Bean
	public TimeTraceAop timeTraceAop() {
		return new TimeTraceAop();
	}
	
	
}
