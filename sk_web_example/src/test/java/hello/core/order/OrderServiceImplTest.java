package hello.core.order;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.AppConfig;
import hello.core.AutoAppConfig;
import hello.core.CommonConfig;
import hello.core.common.TimeTraceAop;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImplTest {
	
	//AnnotationConfigApplicationContext acaop = new AnnotationConfigApplicationContext(CommonConfig.class);
	//AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
//	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class, CommonConfig.class);
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
	
	@Test
	void createOrder(){
		
		TimeTraceAop timetraceAop =  new CommonConfig().timeTraceAop();
		MemberRepository mrp = new MemoryMemberRepository();
		
		Member mb = new Member(2L, "YEOM", Grade.VIP);
		mrp.save(mb);
		DiscountPolicy dcp = ac.getBean(DiscountPolicy.class);
		OrderServiceImpl osi = new OrderServiceImpl(mrp, dcp);
		Order order =  osi.createOrder(2L,"itemA",5000);
		
		
		
		System.out.println(order.getDiscountPrice());
		System.out.println(order.getItemPrice());
		
	}

}
