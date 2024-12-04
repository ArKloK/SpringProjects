package com.firstSpringProject.learn_spring_framework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.firstSpringProject.learn_spring_framework.game.GameRunner;


public class App03GamingSpringBeans {

	public static void main(String[] args) {

		try(var context = new AnnotationConfigApplicationContext(GamingConfiguration.class)){
			context.getBean(GameRunner.class).run();
		}
	}
}
