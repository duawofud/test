package hello.core.singletonTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import hello.core.singleton.SingletonService;

public class SingletonTest {
	
	
	@Test
	@DisplayName("싱글턴패턴 객체")
	void singletonServiceTest() {
		
		SingletonService sc1 = SingletonService.getInstance();
		SingletonService sc2 = SingletonService.getInstance();
		
		System.out.println("sc1 :"+sc1);
		System.out.println("sc2 :"+sc2);
		
	}

}
