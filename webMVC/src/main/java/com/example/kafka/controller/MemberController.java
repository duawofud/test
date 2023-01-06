package com.example.kafka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.kafka.domain.Member;
import com.example.kafka.service.KafkaService;
import com.example.kafka.service.MemberService;

@Controller
public class MemberController {

	private final MemberService memberService;
	private final KafkaService kafkaService;
	

	@Autowired
	public MemberController(MemberService memberService , KafkaService kafkaService) {
		this.memberService = memberService;
		this.kafkaService = kafkaService;
	}

	@GetMapping(value = "/members/new")
	public String createForm() {
		return "members/createMemberForm";
	}

	@PostMapping(value = "/members/new")
	public String create(MemberForm form) {
		Member member = new Member();
		member.setName(form.getName());
		memberService.join(member);
		return "redirect:/";
	}
	
	@GetMapping(value = "/members")
	public String list(Model model) {
	 List<Member> members = memberService.findMembers();
	 System.out.println(" MemberController members : "+ members.get(0) );
	 model.addAttribute("members", members);
	 return "members/memberList";
	}
	
	@GetMapping(value = "/members/kafka")
	public String createFormKafka() {
		return "members/createMemberFormkafka";
	}

	@PostMapping(value = "/members/newkafka")
	public String createKafka(MemberForm form) {
		Member member = new Member();
		member.setName(form.getName());
		kafkaService.sendMessage(member);
		return "redirect:/";
	}	
}