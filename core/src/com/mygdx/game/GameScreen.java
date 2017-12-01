package com.mygdx.game;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	
	private RPSGame rpsGame;
	private Texture rockImg;
	private Texture paperImg;
	private Texture scissorsImg;
	
	public GameScreen(RPSGame rpsGame) {
		this.rpsGame = rpsGame;
		rockImg = new Texture("rock.png");
		paperImg = new Texture("paper.png");
		scissorsImg = new Texture("scissors.png");
	}
	
	@Override
	public void render(float delta) {
		SpriteBatch batch = rpsGame.batch;
		batch.begin();
		batch.draw(rockImg, 50, 50);
		batch.draw(paperImg, 300, 50);
		batch.draw(scissorsImg, 550, 50);
		batch.end();
	}
}