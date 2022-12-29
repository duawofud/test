package hello.core.logging;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.CommonConfig;
import hello.core.common.LoggingServiceImpl;

public class LoggingTest {
	
	@Test
	void commonLoggingTest() {
		
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(CommonConfig.class);
		LoggingServiceImpl loggingServiceImpl = ac.getBean(LoggingServiceImpl.class);
		loggingServiceImpl.insertLog("@@ Insert Log @@");
		System.out.println("loggingServiceImpl1:"+loggingServiceImpl);
		System.out.println("Log Print :"+loggingServiceImpl.printLog());
		System.out.println("loggingServiceImpl2:"+loggingServiceImpl);
		
	}
}
