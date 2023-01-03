package hello.core.singletonTest;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {

		@Test
		void statfuleServiceTest() {
			
			ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
			StatefulService sf1 = ac.getBean(StatefulService.class);
			StatefulService sf2 = ac.getBean(StatefulService.class);
			
			//Thread A사용자가 10000원 주문
			int sf1price = sf1.order("usertA", 10000);
			//Thread B사용자가 10000원 주문
			sf2.order("usertB", 20000);
			
			//Thread A사용자가 10000원 조회
			System.out.println("A price:"+sf1price);
						
			
		}
		
		static class TestConfig{
			
			@Bean
			public StatefulService statefulService() {
				return new StatefulService();
			}
		}
}
