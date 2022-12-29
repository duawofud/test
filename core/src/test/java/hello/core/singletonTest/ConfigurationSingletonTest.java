package hello.core.singletonTest;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;

public class ConfigurationSingletonTest {
	
	
	@Test
	void ConfigurationTest() {
		
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
		
		MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
		OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
		

		MemberRepository memberRepo1 = memberService.getMemberRepository();
		MemberRepository memberRepo2 = orderService.getMemberRepository();
		
		System.out.println("member1 :"+ memberRepo1);
		System.out.println("member2 :"+ memberRepo2);
		
	}
}
