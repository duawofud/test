package hello.core.autowired;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;

public class AllBeanTest {
	
	@Test
	void findAllBean() {
		//Component Scan 범위내에 모든 Autowired 에 주입을 시킴 . (  AutoAppConfig <- ComponentScan 주체 )
		AnnotationConfigApplicationContext ac =  new AnnotationConfigApplicationContext(AutoAppConfig.class , DiscountService.class);
		
		DiscountService discountService =  ac.getBean(DiscountService.class);
		Member member = new Member(1L, "YEOM",Grade.VIP);
		//AutoAppconfig 를 통해, componentScan 을 수행 하고, compenent 로 스캔 된 Bean을 policyMap 객체에 AutoWired 한다 , 이떄 소문자 클래스 명으로 클래스 찾아 올 policy 를 명시한다.

		int disCountPrice = discountService.discount(member , 10000 , "fixDiscountPolicy");
		
		System.out.println("disCountPrice:"+disCountPrice);
		
	}

	
	static class DiscountService{
		private final Map<String, DiscountPolicy> policyMap;
		private List<DiscountPolicy> polices;
		
		//Autowired 에 주입 된 여럿의 Policy 중 key를 통해 원하는 할인정책을 가져온다.
		@Autowired
		public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> polices) {
			this.policyMap = policyMap;
			this.polices = polices;
			System.out.println("policyMap:"+policyMap);
			System.out.println("polices:"+polices);
		}

		public int discount(Member member, int price, String discountUsed) {
			// TODO Auto-generated method stub
			DiscountPolicy discountPolicy = policyMap.get(discountUsed);
			return discountPolicy.discount(member, price);
		}
		
		
	}
	
	
}
 