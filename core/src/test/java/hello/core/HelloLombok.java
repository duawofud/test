package hello.core;

import lombok.Builder;
import lombok.Setter;

@Builder
public class HelloLombok {
	
	@Setter
	private String name;
	private int age;
	
	public static void main(String[] args) {
		HelloLombok helloLombok = new HelloLombok();
	}
}
