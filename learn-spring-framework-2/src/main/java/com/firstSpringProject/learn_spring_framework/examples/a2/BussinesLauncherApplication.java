package com.firstSpringProject.learn_spring_framework.examples.a2;

import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class BussinesLauncherApplication {
	public static void main(String[] args) {

		try (var context = new AnnotationConfigApplicationContext(BussinesLauncherApplication.class)) {
			Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);
			
			System.out.println("Max number " + context.getBean(BusinessCalculationService.class).findMax());
		}
	}
}
