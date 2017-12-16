package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	private RPSGame rpsGame;
	private Condition condition;
	
	private Texture bg;
	private Texture rPlayer;
	private Texture ppPlayer;
	private Texture ssPlayer;
	private Texture rBot;
	private Texture ppBot;
	private Texture ssBot;
	
	boolean newRound = true;
	int bot = 0;
	
	public GameScreen (RPSGame rpsGame) {
		this.rpsGame = rpsGame;
		
		bg = new Texture("bg.png");
		rPlayer = new Texture("rPlayer.png");
		ppPlayer = new Texture("ppPlayer.png");
		ssPlayer = new Texture("ssPlayer.png");
		rBot = new Texture("rBot.png");
		ppBot = new Texture("ppBot.png");
		ssBot = new Texture("ssBot.png");
	}
	
	public void render(float delta) {
		SpriteBatch batch = rpsGame.batch;
		batch.begin();
		batch.draw(bg, 0, 0);
		
		if (rpsGame.card == 1) {
			batch.draw(rPlayer, 300, 50);
		}
		else if (rpsGame.card == 2) {
			batch.draw(ppPlayer, 300, 50);
		}
		else if (rpsGame.card == 3) {
			batch.draw(ssPlayer, 300, 50);
		}
		
		if (newRound) {
			bot = random();
		}
		if (bot == 1) {
			batch.draw(rBot, 300, 320);
		}
		else if (bot == 2) {
			batch.draw(ppBot, 300, 320);
		}
		else if (bot == 3) {
			batch.draw(ssBot, 300, 320);
		}
		newRound = false;
		batch.end();
		
		condition = new Condition(rpsGame.card, bot);
		
	}
	
	public int random () {
		Random rand = new Random();
		
		return rand.nextInt(3) + 1;
	}
}
