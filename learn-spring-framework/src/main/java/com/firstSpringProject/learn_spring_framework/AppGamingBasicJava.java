package com.firstSpringProject.learn_spring_framework;

import com.firstSpringProject.learn_spring_framework.game.GameRunner;
import com.firstSpringProject.learn_spring_framework.game.MarioGame;
import com.firstSpringProject.learn_spring_framework.game.SuperContraGame;

public class AppGamingBasicJava {

	public static void main(String[] args) {
		
		var marioGame = new MarioGame();
		
		var superContraGame = new SuperContraGame();
		
		var gameRunner = new GameRunner(marioGame);
		gameRunner.run();
	}

}
