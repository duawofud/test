package hello.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

@Configuration
@ComponentScan(
		excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION , classes = Configuration.class)
)

//Componenent 을 의존관계 주입 대상에다가 선언하고, 의존관계 주입에 대한 코드를 AutoWired 로 대신한다.

public class AutoAppConfig {
	
	@Bean
	public MemberRepository memberRepository() {
		return new MemoryMemberRepository();
	}

}
