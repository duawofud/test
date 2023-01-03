package hello.core.beanfind;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Map;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class ApplicationContextSameBeanTest {
	
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);
	
	@Test
	@DisplayName("동일타입 존재 시, 에러남.")
	void findBeanTypeDuplication() {
		assertThrows(NoUniqueBeanDefinitionException.class, () -> ac.getBean(MemberRepository.class));
	}
	
	@Test
	@DisplayName("타입으로 조회시 같은 타입이 둘 이상있으면, 빈 이름을 지정하자.")
	void fidnBeanByName() {
		MemberRepository memberRepository = ac.getBean("memberRepository1", MemberRepository.class);
		assertThat(memberRepository).isInstanceOf(MemberRepository.class);
	
	}
	
	
	@Test
	@DisplayName("특정 타입 모두 조회")
	void findAllBeanByType() {
		Map<String, MemberRepository> beanOfType = ac.getBeansOfType(MemberRepository.class);
		for (String beanOfTypeString : beanOfType.keySet()) {
			System.out.println("key:"+beanOfTypeString);
		}
	}

	
	@Test
	@DisplayName("최상위 타입 모두 조회")
	void findAllBeanObj() {
		Map<String, Object> beanOfType = ac.getBeansOfType(Object.class);
		for (String beanOfTypeString : beanOfType.keySet()) {
			System.out.println("key:"+ beanOfType + "   value : "+beanOfType.get(beanOfTypeString));
		}
	}
	
	// 내부 static 클래스 선언 시 Scope 를 해당 클래스 에서만 사용
	@Configuration
	static class SameBeanConfig {
		
		@Bean
		public MemberRepository memberRepository1() {
			return new MemoryMemberRepository();
		}
		
		@Bean
		public MemberRepository memberRepository2() {
			return new MemoryMemberRepository();
		}
		
	}
	
}
