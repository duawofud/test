package hello.core.member;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

@Component
public class MemoryMemberRepository implements MemberRepository{

	// 실무에선 왠만해선, thread 순차 처리를 위해 ConcurrentHashMap 을 사용 하자.
	private static Map<Long , Member> store = new ConcurrentHashMap<Long, Member>();
	
	@Override
	public void save(Member member) {
		// TODO Auto-generated method stub
		store.put(member.getId(), member);
	}

	@Override
	public Member findById(Long memberId) {
		// TODO Auto-generated method stub
		return store.get(memberId);
	}
	
}
