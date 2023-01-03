package hello.core.discount;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import hello.core.member.Grade;
import hello.core.member.Member;

@Component
@Primary
public class FixDiscountPolicy implements DiscountPolicy {
	
	private int discountFixAmount = 1000; //고정금액

	@Override
	public int discount(Member member, int price) {
		// TODO Auto-generated method stub
		if (member.getGrade() == Grade.VIP) {
			return discountFixAmount;
		}else {
			return 0;
		}
			
	}

		
	
	
}
