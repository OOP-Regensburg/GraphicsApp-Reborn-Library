package de.ur.mi.graphicsapp2.desktop.examples.breakout.states;

import de.ur.mi.graphicsapp2.desktop.examples.breakout.Breakout;

public class GameStatePlaying implements GameState {
	
	public GameStatePlaying(Breakout game) {
		game.play();
	}
	
	@Override
	public void play(Breakout game) {

	}

	@Override
	public void loseRound(Breakout game) {		
		if (game.numberOfRemainingRounds() > 0) {
			game.removeOneRound();
			game.setState(new GameStateReady());
		} else { 
			game.setState(new GameStateNew(game));
		}
	}

}