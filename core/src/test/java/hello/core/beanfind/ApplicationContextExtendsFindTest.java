package hello.core.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;

public class ApplicationContextExtendsFindTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
	
	@Test
	@DisplayName("부모타입 조회 시 자식이 둘 이상있으면 중복오류")
	void findBeanByParentTypeDuplicate() {
		assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(DiscountPolicy.class));
		
	}
	
	
	@Test
	@DisplayName("빈 이름 지정 시 이슈 없음.")
	void findBeanByParentTypeBeanName() {
		DiscountPolicy rateDisCountPolicy = ac.getBean("rateDisCountPolicy" , DiscountPolicy.class);
		assertThat(rateDisCountPolicy).isInstanceOf(RateDiscountPolicy.class);
	}

	@Test
	@DisplayName("하위 타입 지정 시 이슈 없음.")
	void findBeanBySubType() {
		RateDiscountPolicy rateDisCountPolicy = ac.getBean(RateDiscountPolicy.class);
		assertThat(rateDisCountPolicy).isInstanceOf(RateDiscountPolicy.class);
	}
	
	
	
	@Configuration
	static class TestConfig {
		
		@Bean
		public DiscountPolicy rateDisCountPolicy() {
			return new RateDiscountPolicy();
		}
		
		@Bean
		public DiscountPolicy FixDisCountPolicy() {
			return new FixDiscountPolicy();
		}
		
	}
}
