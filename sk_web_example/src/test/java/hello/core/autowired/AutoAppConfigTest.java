package hello.core.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AutoAppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;

public class AutoAppConfigTest {

		@Test
		void basicScan() {
			AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
			MemberService memberService = ac.getBean(MemberService.class);
			OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
			
		}
}
