package hello.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;

public class MemberApp {

	public static void main(String[] args) {
		
//		AppConfig appConfig = new AppConfig();
//		MemberService memberService = appConfig.memberService();
		
		//스프링  기본문법
		//스프링 객체에다가 AppConfig 에서 생성한 모든 객체를 담어두고 있음 (Confiig 및 Bean 정의된 것 )
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); 
		MemberService memberService= applicationContext.getBean("memberService",MemberService.class);
		String nameValue = applicationContext.getBean("owner" , String.class);
		
		Member member = new Member( 1L, "memberA", Grade.VIP);
		memberService.join(member);
		
		Member findMember = memberService.findMember(1L);
		System.out.println("new member : "+ member.getName());
		System.out.println("findmember : "+ findMember.getName());
		System.out.println(nameValue);
		
	}
}
