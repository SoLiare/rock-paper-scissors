package com.mygdx.game;

import java.util.Random;

public class Condition {
	int cases = 2;
	int buttonNum = 0;
	
	public Condition (int player, int bot) {
		if(bot == player) {
			cases = 0;
			buttonNum = 2;
		}
		else {
			if(player - bot == 1 || player - bot == -2) {
				cases = 1;
				buttonNum = 1;
			}
			else {
				cases = -1;
				buttonNum = 3;
			}
		}
	}
	
	public int random () {
		Random rand = new Random();
		return rand.nextInt(4);
	}
}
