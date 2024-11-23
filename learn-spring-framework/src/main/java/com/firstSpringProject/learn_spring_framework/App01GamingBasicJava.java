package com.firstSpringProject.learn_spring_framework;

import com.firstSpringProject.learn_spring_framework.game.GameRunner;
import com.firstSpringProject.learn_spring_framework.game.MarioGame;
import com.firstSpringProject.learn_spring_framework.game.PacmanGame;
import com.firstSpringProject.learn_spring_framework.game.SuperContraGame;

public class App01GamingBasicJava {

	public static void main(String[] args) {

		var marioGame = new MarioGame();

		var superContraGame = new SuperContraGame();
		PacmanGame pacmanGame = new PacmanGame();

		var gameRunner = new GameRunner(pacmanGame);
		gameRunner.run();
	}
}
