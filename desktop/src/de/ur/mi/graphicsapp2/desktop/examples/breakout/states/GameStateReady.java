package de.ur.mi.graphicsapp2.desktop.examples.breakout.states;

import de.ur.mi.graphicsapp2.desktop.examples.breakout.Breakout;

public class GameStateReady implements GameState {
	
	@Override
	public void play(Breakout game) {
		game.resetBall();
		game.setState(new GameStatePlaying(game));
	}

	@Override
	public void loseRound(Breakout game) {
		
	}

}