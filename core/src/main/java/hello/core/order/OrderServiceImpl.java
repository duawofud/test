package hello.core.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;

// OrderService 를 구현하는 구현체 > OrderServiceImpl

@Component
public class OrderServiceImpl implements OrderService {

	private final MemberRepository memberRepository;
	private final DiscountPolicy discountPolicy;
	
	// 동적 객체 인스턴스 구현 
	// 저장소와 할인율 구현체는 AppConfig 에서 생성 및 주입한 방식으로 처리 (의존관계 주입)
	// 의존관계 주입 시  OrderServiceImpl (클라이언트) 코드를 수정하지 않아도 됨.
	// OrderServiceImpl 에서 궂이 구현코드 MemoryMemberRepository , FixDiscountPolicy 를 정의하지 않아도 됨 **
	

	@Autowired // 생성자가 하나 뿐 이면 , Autowired 생략 가능.
	public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
		System.out.println("-first");
		this.memberRepository = memberRepository;
		this.discountPolicy = discountPolicy;
	} 	
	

	@Override
	public Order createOrder(Long memberId, String itemName, int itemPrice) {
	// TODO Auto-generated method stub\
		
		Member member = memberRepository.findById(memberId);
		int discountPrice = discountPolicy.discount(member, itemPrice);
		
		return new Order(memberId,itemName ,itemPrice, discountPrice);
	}
	
	
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
	

	
}
