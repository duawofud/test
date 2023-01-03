package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import hello.core.CommonConfig;
import hello.core.common.LoggingRepo;
import hello.core.common.LoggingServiceImpl;

@Component
public class MemberServiceImpl implements MemberService {

	
	/**
	 * 
	 * 1. 인터페이스 를 구현하기위해 구현정의 (implements)
	 * 2. 인터페이스에서 정의한 메소드 @Override
	 * 3. 생성자 를 통해 이 구현체(클래스) 는 어떤 구현클래스를 주입 받을 지 초기로딩
	 * 4. 파라미터는 AppConig 에서 정의한 값이 넘어옴. ( AppConfig 에서 new MemoryRepository 로 생성해서 넘겨 줌 )
	 * 5. MemberServiceImpl 에서는 MemoryRepository 저장소를 사용
	 * 6. Main 함수에서 MemberServiceImpl 구현체의 구현 메소드를 상황에 맞게 호출.
	 * 7. 구현체에다가 Compnent 생성
	 * 8. 생성자에다가 AutoWired 를 지정하면, 스프링 컨테이너가 초기생성 시 자동생성 후 주입. (생성자 파라미터가 여러개여도 알아서 주입해줌 .)
	 */
	
	AnnotationConfigApplicationContext customAc = new AnnotationConfigApplicationContext(CommonConfig.class);
	LoggingServiceImpl loggingServiceImpl = customAc.getBean(LoggingServiceImpl.class);
	
	private final MemberRepository memberRepository;
//	private final LoggingRepo loggingRepo;
	
	@Autowired //ac.getBean(MemberRepository.class);
	public MemberServiceImpl(MemberRepository memberRepository) {
		this.memberRepository =  memberRepository;
	}
	
	
	@Override
	public void join(Member member) {
		// TODO Auto-generated method stub
		loggingServiceImpl.insertLog("등록 한 맴버 이름은 "+member+" 입니다");
		memberRepository.save(member);
	}

	@Override
	public Member findMember(Long memberId) {
		// TODO Auto-generated method stub
		loggingServiceImpl.printLog();
		return memberRepository.findById(memberId);
	}
	
	public MemberRepository getMemberRepository() {
		return memberRepository;
	}
	

	
}
