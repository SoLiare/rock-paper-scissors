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
			batch.draw(rFaded, 50, 185);
			batch.draw(ppPlayer, 300, 185);
			batch.draw(ssFaded, 550, 185);
		}
		else if (n == 1) {
			batch.draw(rPlayer, 50, 185);
			batch.draw(ppFaded, 300, 185);
			batch.draw(ssFaded, 550, 185);
		}
		else {
			batch.draw(rFaded, 50, 185);
			batch.draw(ppFaded, 300, 185);
			batch.draw(ssPlayer, 550, 185);
		}
		batch.end();
		
		n = position(n);
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
