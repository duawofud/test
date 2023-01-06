package com.example.kafka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
	
	@GetMapping("hello-mvc")
	public String helloMvc(@RequestParam("name") String name, Model model) {
		model.addAttribute("name", name);
		return "hello-template";
	}
	
	@GetMapping("hello-string")
	@ResponseBody // json return 이 default  // API 방식 : 객체리턴 
	public String helloString(@RequestParam("name") String name) {
		return "hello :"+ name;
	}
	
	@GetMapping("apiCall")
	@ResponseBody
	public Hello apiCall(@RequestParam("name") String name) {
		
		Hello hello = new Hello();
		hello.setName("Yeom");
		
		return hello;
	}
	
	
	
	//테스트용 임시 내부 클래스
	static class Hello {
		
		private String name ;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
		
	}
	
}