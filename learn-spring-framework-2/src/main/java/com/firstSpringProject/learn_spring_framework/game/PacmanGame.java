package com.firstSpringProject.learn_spring_framework.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("PacmanGameQualifier")
public class PacmanGame implements GamingConsole{

	public void up() {
		System.out.println("Up");
	}

	public void down() {
		System.out.println("Down");
	}

	public void left() {
		System.out.println("Left");
	}

	public void right() {
		System.out.println("Right");
	}

}
