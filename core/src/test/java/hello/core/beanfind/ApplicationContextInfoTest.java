package hello.core.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;

public class ApplicationContextInfoTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
	@Test
	@DisplayName("AllBean Print")
	void findAllBean() {
		String[] beanDeafinitionNames = ac.getBeanDefinitionNames();
		// beanDeafinitionName <- beanDeafinitionNames
		for (String beanDeafinitionName : beanDeafinitionNames) {
			Object bean = ac.getBean(beanDeafinitionName);
			System.out.println("definition bean Name:"+ beanDeafinitionName + "object:" + bean);
		}
		
	}
	
	@Test
	@DisplayName("AllBean filter")
	void findApplicationbBean() {
		String[] beanDeafinitionNames = ac.getBeanDefinitionNames();
		// beanDeafinitionName <- beanDeafinitionNames
		for (String beanDeafinitionName : beanDeafinitionNames) {
			BeanDefinition beanDefinition = ac.getBeanDefinition(beanDeafinitionName);

			
			//Role ROLE_APPLICATION : 내가 직접 등록한 빈.
			//Role ROLE_INFRASTRURCT : 스프링 내부 사용 빈.
			
			if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
				Object bean = ac.getBean(beanDeafinitionName);
				System.out.println("definition bean Name:"+ beanDeafinitionName + " --- object:" + bean);				
			}
			
			
		}
		
	}
	
}
