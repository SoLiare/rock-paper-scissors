package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class ChooseScreen extends ScreenAdapter {
	private RPSGame rpsGame;
	private Texture bg;
	private Texture rPlayer;
	private Texture ppPlayer;
	private Texture ssPlayer;
	private Texture rFaded;
	private Texture ppFaded;
	private Texture ssFaded;
	
	int n = 2;
	int xL = 50;
	int xC = 300;
	int xR = 550;
	int y = 185;
	
	public ChooseScreen(RPSGame rpsGame) {
		this.rpsGame = rpsGame;
		
		bg = new Texture("bg.png");
		rPlayer = new Texture("rPlayer.png");
		ppPlayer = new Texture("ppPlayer.png");
		ssPlayer = new Texture("ssPlayer.png");
		rFaded = new Texture("rFaded.png");
		ppFaded = new Texture("ppFaded.png");
		ssFaded = new Texture("ssFaded.png");
	}
	
	public void render(float delta) {
		SpriteBatch batch = rpsGame.batch;
		batch.begin();
		batch.draw(bg, 0, 0);
		if (n == 2) {
			batch.draw(rFaded, xL, y);
			batch.draw(ppPlayer, xC, y);
			batch.draw(ssFaded, xR, y);
		}
		else if (n == 1) {
			batch.draw(rPlayer, xL, y);
			batch.draw(ppFaded, xC, y);
			batch.draw(ssFaded, xR, y);
		}
		else {
			batch.draw(rFaded, xL, y);
			batch.draw(ppFaded, xC, y);
			batch.draw(ssPlayer, xR, y);
		}
		batch.end();
		
		n = position(n);
		
		if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
			rpsGame.start = true;
			rpsGame.card = n;
			rpsGame.create();
		}
	}
	
	public int position (int n) {
		if (Gdx.input.isKeyJustPressed(Keys.LEFT)) {
			if (n > 1) {
				n = n - 1;
				return n;
			}
		}
		else if (Gdx.input.isKeyJustPressed(Keys.RIGHT)) {
			if (n < 3) {
				n = n + 1;
				return n;
			}
		}
		return n;
	}
}
