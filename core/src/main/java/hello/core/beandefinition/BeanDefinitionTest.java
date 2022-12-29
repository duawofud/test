package hello.core.beandefinition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hello.core.AppConfig;

public class BeanDefinitionTest {

	AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
	
}
