package com.firstSpringProject.learn_spring_framework;

import com.firstSpringProject.learn_spring_framework.game.GameRunner;
import com.firstSpringProject.learn_spring_framework.game.PacmanGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {
		PacmanGame pacmanGame = new PacmanGame();

		var gameRunner = new GameRunner(pacmanGame);
		gameRunner.run();
	}
}
