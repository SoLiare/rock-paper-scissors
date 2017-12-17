package com.mygdx.game;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen extends ScreenAdapter {
	private RPSGame rpsGame;
	private Condition condition;
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
			batch.draw(rPlayer, 300, 50);
		}
		else if(rpsGame.card == 2) {
			batch.draw(ppPlayer, 300, 50);
		}
		else if(rpsGame.card == 3) {
			batch.draw(ssPlayer, 300, 50);
		}
		
		if(newRound) {
			bot = random();
		}
		if(bot == 1) {
			batch.draw(rBot, 300, 320);
		}
		else if(bot == 2) {
			batch.draw(ppBot, 300, 320);
		}
		else if(bot == 3) {
			batch.draw(ssBot, 300, 320);
		}
		
		if(newRound) {
			condition = new Condition(rpsGame.card, bot);
		}
		
		if(condition.buttonNum > 0 && time < 250) {
			if(button == 4) {
				button = condition.random();
				time = 0;
			}
			
			if(button == 0) {
				batch.draw(w, 50, 250);

				if(Gdx.input.isKeyJustPressed(Keys.W)) {
					mash = mash + 1;
				}
			}
			else if(button == 1) {
				batch.draw(s, 50, 250);
				
				if(Gdx.input.isKeyJustPressed(Keys.S)) {
					mash = mash + 1;
				}
			}
			else if(button == 2) {
				batch.draw(a, 50, 250);
				
				if(Gdx.input.isKeyJustPressed(Keys.A)) {
					mash = mash + 1;
				}
			}
			else if(button == 3) {
				batch.draw(d, 50, 250);
				
				if(Gdx.input.isKeyJustPressed(Keys.D)) {
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
			System.out.println(time);
		}
		else {
			rpsGame.start = false;
			batch.draw(gameOver, 0, 0);
			if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
				rpsGame.goal = 10;
				rpsGame.create();
			}
		}
		
		newRound = false;
		
		if(condition.buttonNum == 0) {
			rpsGame.start = false;
			batch.draw(nextStage, 0, 0);
			if(Gdx.input.isKeyJustPressed(Keys.ENTER)) {
				rpsGame.goal = rpsGame.goal + 5;
				rpsGame.create();
			}
		}
		batch.end();
	}
	
	public int random() {
		Random rand = new Random();
		return rand.nextInt(3) + 1;
	}
}
