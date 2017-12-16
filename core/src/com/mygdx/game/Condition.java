package com.mygdx.game;

public class Condition {
	int cases = 2;
	int button = 0;
	
	public Condition (int player, int bot) {
		if (bot == player) {
			cases = 0;
			button = 2;
		}
		else {
			if (player - bot == 1 || player - bot == -2) {
				cases = 1;
				button = 1;
			}
			else {
				cases = -1;
				button = 3;
			}
		}
	}
	
	
}
