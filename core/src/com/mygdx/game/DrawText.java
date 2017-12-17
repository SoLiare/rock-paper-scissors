package com.mygdx.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

public class DrawText {
	BitmapFont font;
	
	public DrawText (Batch batch,String str, int x, int y) {
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		font.getData().scale(2);
		font.draw(batch, str, x, y);
	}
}
