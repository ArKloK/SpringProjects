package com.firstSpringProject.learn_spring_framework.HelloWorld;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {

	public static void main(String[] args) {

		// 1: Launch a Spring Context

		try (var context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class)) {
			
			// 2: Configure the things that we want Spring to manage
			// HelloWorldConfiguration - @Configuration
			// name - @Bean

			// 3: Retrieving Beans managed by Spring
			System.out.println(context.getBean("name"));
			System.out.println(context.getBean("age"));
			System.out.println(context.getBean(Person.class));
			System.out.println(context.getBean("personMethodCall"));
			System.out.println(context.getBean("personParameters"));
			System.out.println(context.getBean("address2"));
		}

	}
}
