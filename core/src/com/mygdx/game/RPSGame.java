package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class RPSGame extends Game {
	public SpriteBatch batch;
	
	boolean start = false;
	int card = 0;
	int goal = 5;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new ChooseScreen(this));
		if(start) {
			setScreen(new GameScreen(this));
		}
	}

	@Override
	public void render () {
		super.render();
	}
		
	@Override
	public void dispose () {
		batch.dispose();
	}
}
