package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;

public class GameScreen extends ScreenAdapter {
	
	private RPSGame rpsGame;
	
	public GameScreen(RPSGame rpsGame) {
		this.rpsGame = rpsGame;
	}
}