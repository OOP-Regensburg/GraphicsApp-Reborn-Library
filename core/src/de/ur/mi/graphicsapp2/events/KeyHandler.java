package de.ur.mi.graphicsapp2.events;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;

import java.util.ArrayList;

public class KeyHandler implements InputProcessor {
    private static ArrayList<KeyListener> keyListeners = new ArrayList<KeyListener>();

    public KeyHandler(KeyListener keyListener){
        keyListeners.add(keyListener);
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keycode) {
        KeyEvent keyEvent = new KeyEvent((char)keycode,keycode);
        for (KeyListener keyListener: keyListeners
             ) {
            keyListener.keyPressed(keyEvent);
        }
        return true;
    }

    @Override
    public boolean keyUp(int keycode) {
        KeyEvent keyEvent = new KeyEvent((char)keycode,keycode);
        for (KeyListener keyListener: keyListeners
        ) {
            keyListener.keyReleased(keyEvent);
        }
        return true;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
