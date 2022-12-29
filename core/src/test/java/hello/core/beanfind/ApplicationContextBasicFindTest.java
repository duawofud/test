package hello.core.beanfind;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;
import hello.core.CommonConfig;
import hello.core.common.LoggingServiceImpl;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class ApplicationContextBasicFindTest {
	
	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	AnnotationConfigApplicationContext aclog = new AnnotationConfigApplicationContext(CommonConfig.class);
	
	@Test
	@DisplayName("이름조회")
	void findBeanByName() {
		MemberService memberService = ac.getBean("memberService", MemberService.class);
		LoggingServiceImpl loggingServiceImpl = aclog.getBean(LoggingServiceImpl.class);
		loggingServiceImpl.insertLog("Common LogSetting");
		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
		System.out.println("aclog:"+loggingServiceImpl.printLog());
	}

//	@Test
//	@DisplayName("타입조회")
//	void findBeanByType() {
//		MemberService memberService = ac.getBean(MemberService.class);
//		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
//	}
//
//	@Test
//	@DisplayName("구체타입 조회")
//	void findBeanByName2() {
//		MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);
//		assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
//	}	
//	
//
//	@Test
//	@DisplayName("타입조회 x")
//	void findBeanByTypeX() {
//		assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("AAA",String.class));
//		
//	}
	
	
}
