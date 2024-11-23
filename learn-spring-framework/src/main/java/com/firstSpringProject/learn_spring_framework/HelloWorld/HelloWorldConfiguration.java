package com.firstSpringProject.learn_spring_framework.HelloWorld;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) {}
record Address (String firstLine, String city) {}

@Configuration
public class HelloWorldConfiguration {

	@Bean
	public String name() {
		return "Carlos";
	}

	@Bean
	public int age() {
		return 20;
	}
	
	@Bean
	@Primary //Set this method as the default option when there are multiple candidates
	public Person person() {
		return new Person("Pepe", 19, new Address("Calle 2", "Badalona"));
	}
	
	@Bean
	public Person personMethodCall() {
		return new Person(name(), age(), address());
	}
	
	@Bean
	public Person personParameters(String name, int age, Address address2) {
		return new Person(name, age, address2);
	}
	
	@Bean(name = "address2")
	public Address address() {
		return new Address("Calle", "Ciudad");
	}
}
