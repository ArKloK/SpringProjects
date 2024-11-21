package com.firstSpringProject.learn_spring_framework.game;

public class GameRunner {
	GamingConsole marioGame;

	public GameRunner(GamingConsole marioGame) {
		this.marioGame = marioGame;
	}

	public void run() {
		System.out.println("Running game: " + marioGame);
		marioGame.up();
		marioGame.down();
		marioGame.left();
		marioGame.right();
	}

}
