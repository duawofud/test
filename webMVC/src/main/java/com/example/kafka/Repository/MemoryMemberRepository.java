package com.example.kafka.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.example.kafka.domain.Member;

@Repository
@Primary
public class MemoryMemberRepository implements MemberRepository{

	private static ConcurrentHashMap<Long , Member> store = new ConcurrentHashMap<>();
	private static Long sequece = 0L;
	
	
	@Override
	public Member save(Member member) {
		// TODO Auto-generated method stub
		member.setId(++sequece);
		store.put(member.getId(), member);
		return member;
	}

	@Override
	public Optional<Member> findById(Long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(store.get(id));
	}

	@Override
	public Optional<Member> findByName(String Name) {
		// TODO Auto-generated method stub
		return store.values().stream()
				 .filter(member -> member.getName().equals(Name))
				 .findAny();
	}

	@Override
	public List<Member> findAll() {
		// TODO Auto-generated method stub
		return new ArrayList<>(store.values());
	}

	@Override
	public void clearStore(Long id) {
		// TODO Auto-generated method stub
		store.remove(id);
	}



}
