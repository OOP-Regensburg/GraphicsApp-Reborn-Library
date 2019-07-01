package de.ur.mi.graphicsapp2.desktop.examples.breakout;

import de.ur.mi.graphicsapp2.sound.Sound;

public class SoundPlayer {

	private static final String BRICK_REMOVED_FILE = "boing.wav";
	
	private Sound brickRemovedSound;
	
	public SoundPlayer() {
		setup();
	}
	
	private void setup() {
		brickRemovedSound = new Sound(BRICK_REMOVED_FILE);
	}

	public void playBrickRemovedSound() {
		brickRemovedSound.play();
	}
	
}