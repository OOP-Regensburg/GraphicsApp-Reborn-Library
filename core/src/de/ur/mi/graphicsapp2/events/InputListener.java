package de.ur.mi.graphicsapp2.events;

public interface InputListener {
    void keyPressed(KeyEvent event);

    void keyReleased(KeyEvent event);

    void mouseClicked(MouseEvent event);

    void mouseReleased(MouseEvent event);
}
