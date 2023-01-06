package com.example.kafka.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kafka.Repository.MemberRepository;
import com.example.kafka.domain.Member;

import jakarta.transaction.Transactional;

@Transactional
public class MemberService {

	private final MemberRepository memberRepo;
	
	@Autowired
	public MemberService(MemberRepository memberRepo) {
		this.memberRepo = memberRepo;
	}

	public Long join(Member member) {
		validateDuplicateMember(member);
		memberRepo.save(member);
		return member.getId();
	}
	
	//중복체크 자바 1.8 부터지원
	private void validateDuplicateMember(Member member) {
		memberRepo.findByName(member.getName()).ifPresent(m -> {
			 throw new IllegalStateException("이미 존재하는 회원입니다.");
		 });
	}
	
	public List<Member> findMembers(){
		List<Member> findAll = memberRepo.findAll();
		return findAll;
	}
	
}
