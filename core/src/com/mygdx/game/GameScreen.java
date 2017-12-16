package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	private RPSGame rpsGame;	
	private Texture bg;
	private Texture rPlayer;
	private Texture ppPlayer;
	private Texture ssPlayer;
	
	public GameScreen (RPSGame rpsGame) {
		this.rpsGame = rpsGame;
		
		bg = new Texture("bg.png");
		rPlayer = new Texture("rPlayer.png");
		ppPlayer = new Texture("ppPlayer.png");
		ssPlayer = new Texture("ssPlayer.png");
	}
	
	public void render(float delta) {
		SpriteBatch batch = rpsGame.batch;
		batch.begin();
		batch.draw(bg, 0, 0);
		batch.end();
	}
}
