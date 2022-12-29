package hello.core.discount;

import org.springframework.stereotype.Component;

import hello.core.member.Grade;
import hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {

	private int discoutPercent = 10;
	
	@Override
	public int discount(Member member, int price) {
		// TODO Auto-generated method stub
		if (member.getGrade() == Grade.VIP) {
			return price * discoutPercent / 100;
		}else{
			return 0;
		}
		
	}

}
