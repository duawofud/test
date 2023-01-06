package com.example.kafka.Repository;

import java.util.List;
import java.util.Optional;

import com.example.kafka.domain.Member;

public interface MemberRepository {

	Member save(Member member);
	
	Optional<Member> findById(Long id);
	Optional<Member> findByName(String Name);
	List<Member> findAll();
	void clearStore(Long id);
	
}
