package hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

/**
 * 
 * @author Administrator
 * 구성영역 (DI 영역)
 * 연결 클래스 (클라이언트 영역코드 변경없이 수정하기 위함. )
 * 리팩토링 > 구성(클래스), 와 역활(인터페이스) 를 나누고 가시성을 높히자.
 * DI(의존관계 주입) 담당 클래스를 DI Container 라고 지칭.
 * 구성정보
 * - Bean 의 경우 메서드만 허용.
 * - Bean type 으로 조회 시 동일타입이 있으면 에러가 나니, 왠만하면 이름 지정하자.
 */

@Configuration
public class AppConfig {
	
	@Bean
	public MemberService memberService() {
		return new MemberServiceImpl(memberRepository());
	}
	
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}
	
	@Bean	
	public OrderService orderService() {
		return new OrderServiceImpl(memberRepository(), discountPolicy());
	}
	
	@Bean	
	public DiscountPolicy discountPolicy() {
		return new RateDiscountPolicy();
	}
	
	@Bean(name="owner")
	public String testString(){
		return "Yeom";
	}
	
	
	
	
}
