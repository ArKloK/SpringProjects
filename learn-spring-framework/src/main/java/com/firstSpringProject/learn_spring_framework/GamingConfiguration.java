package com.firstSpringProject.learn_spring_framework;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.firstSpringProject.learn_spring_framework.game.GameRunner;
import com.firstSpringProject.learn_spring_framework.game.GamingConsole;
import com.firstSpringProject.learn_spring_framework.game.PacmanGame;

@Configuration
public class GamingConfiguration {
	
	@Bean
	public GamingConsole game() {
		return new PacmanGame();
	}
	
	@Bean
	public GameRunner gameRunner(GamingConsole game) {
		return new GameRunner(game);
	}

}
