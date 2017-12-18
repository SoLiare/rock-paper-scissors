package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	private RPSGame rpsGame;
	private Condition condition;
	private DrawText drawText;
	private Texture bg;
	private Texture nextStage;
	private Texture gameOver;
	private Texture rPlayer;
	private Texture ppPlayer;
	private Texture ssPlayer;
	private Texture rBot;
	private Texture ppBot;
	private Texture ssBot;
	private Texture w;
	private Texture s;
	private Texture a;
	private Texture d;
	
	boolean newRound = true;
	int bot = 0;
	
	boolean win = false;
	int mash = 0;
	int button = 4;
	int time = 0;
	int limits = 85;
	
	int x = 300;
	int yPlayer = 50;
	int yBot = 320;
	
	int xBut = 50;
	int yBut = 250;
			
	public GameScreen (RPSGame rpsGame) {
		this.rpsGame = rpsGame;
		bg = new Texture("bg.png");
		nextStage = new Texture("nextStage.png");
		gameOver = new Texture("gameOver.png");
		rPlayer = new Texture("rPlayer.png");
		ppPlayer = new Texture("ppPlayer.png");
		ssPlayer = new Texture("ssPlayer.png");
		rBot = new Texture("rBot.png");
		ppBot = new Texture("ppBot.png");
		ssBot = new Texture("ssBot.png");
		w = new Texture("wButton.png");
		s = new Texture("sButton.png");
		a = new Texture("aButton.png");
		d = new Texture("dButton.png");
	}

	public void render (float delta) {
		SpriteBatch batch = rpsGame.batch;
		batch.begin();
		batch.draw(bg, 0, 0);
		
		if(rpsGame.card == 1) {
			batch.draw(rPlayer, x, yPlayer);
		}
		else if(rpsGame.card == 2) {
			batch.draw(ppPlayer, x, yPlayer);
		}
		else if(rpsGame.card == 3) {
			batch.draw(ssPlayer, x, yPlayer);
		}
		
		if(newRound) {
			bot = random();
		}
		if(bot == 1) {
			batch.draw(rBot, x, yBot);
		}
		else if(bot == 2) {
			batch.draw(ppBot, x, yBot);
		}
		else if(bot == 3) {
			batch.draw(ssBot, x, yBot);
		}
		
		if(newRound) {
			condition = new Condition(rpsGame.card, bot);
		}
		
		if(condition.buttonNum > 0 && time < limits) {
			if(button == 4) {
				button = condition.random();
				time = 0;
			}
			
			if(button == 0) {
				batch.draw(w, xBut, yBut);

				if(Gdx.input.isKeyPressed(Keys.W)) {
					mash = mash + 1;
				}
			}
			else if(button == 1) {
				batch.draw(s, xBut, yBut);
				
				if(Gdx.input.isKeyPressed(Keys.S)) {
					mash = mash + 1;
				}
			}
			else if(button == 2) {
				batch.draw(a, xBut, yBut);
				
				if(Gdx.input.isKeyPressed(Keys.A)) {
					mash = mash + 1;
				}
			}
			else if(button == 3) {
				batch.draw(d, xBut, yBut);
				
				if(Gdx.input.isKeyPressed(Keys.D)) {
					mash = mash + 1;
				}
			}
			
			if(rpsGame.goal == mash) {
				win = true;
			}
			
			if(win) {
				mash = 0;
				condition.buttonNum = condition.buttonNum - 1;
				button = 4;
				win = false;
			}
			
			time = time + 1;
		}
		else if(condition.buttonNum > 0 && time >= limits) {
			rpsGame.start = false;
			batch.draw(gameOver, 0, 0);
			if(rpsGame.level > rpsGame.highScore) {
				rpsGame.highScore = rpsGame.level;
			}
			
			drawText = new DrawText(batch, "Level: " + rpsGame.level + "\nHighest Level: " + rpsGame.highScore, 250, 300);
			
			if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
				rpsGame.level = 0;
				rpsGame.goal = 10;
				rpsGame.create();
			}
		}
		else if(condition.buttonNum == 0) {
			rpsGame.start = false;
			batch.draw(nextStage, 0, 0);
			if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
				rpsGame.goal = rpsGame.goal + 5;
				rpsGame.level = rpsGame.level + 1;
				rpsGame.create();
			}
		}
		newRound = false;
		
		batch.end();
	}
	
	public int random() {
		Random rand = new Random();
		return rand.nextInt(3) + 1;
	}
}
