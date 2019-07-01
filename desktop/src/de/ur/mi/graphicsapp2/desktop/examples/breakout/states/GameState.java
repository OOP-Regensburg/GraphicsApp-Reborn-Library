package de.ur.mi.graphicsapp2.desktop.examples.breakout.states;

import de.ur.mi.graphicsapp2.desktop.examples.breakout.Breakout;

public interface GameState {
	
	public void play(Breakout game);
	public void loseRound(Breakout game);

}