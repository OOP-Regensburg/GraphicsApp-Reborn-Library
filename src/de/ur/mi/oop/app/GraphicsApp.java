package de.ur.mi.oop.app;

import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.events.*;
import de.ur.mi.oop.graphics.Background;

import java.awt.event.MouseEvent;

/*! \mainpage GraphicsApp API
 *
 * Die GraphicsApp-Bibliothek ist eine einfache 2D-Grafikumgebung für die JAVA-Laufzeitumgebung.
 * Sie dient in erster Linie dazu, Programmiernovizen an die Verwendung der Programmiersprache Java heranzuführen.
 * Die Programmierenden können auf Basis der Bibliothek eigene graphische Anwendungen gestalten.
 * Grundlage dafür ist ein Lifecycle, bestehend aus einer Initalisierungsphase sowie eines einfachen Game loop.
 * Die Bibliothek erlaubt das Erstellen, Darstellen und dynamisches Manipulieren graphischer Primitive.
 *
 */

/**
 * Dies ist die abstrakte Basisklasse für alle GraphicsApp-Anwendungen. Jedes Programm erbt von dieser Klasse
 * und verfügt über die hier implementierten Funktionen. Die Programmier*innen überschreibt die `draw()`- und
 * `initialize()`-Methoden, um die spezifischen Funktionen des eigenen GraphicsApp-Programms umzusetzten. Ein
 * solches Programm kann dann über eine `main`-Methode und die Verwendung desGraphicsAppLauncher gestartet werden.
 */
public abstract class GraphicsApp extends GraphicsAppCore implements GraphicsAppKeyListener, GraphicsAppMouseListener {

    private Background background;

    public GraphicsApp() {
        super();
    }

    /**
     * Wird einmalig zu Programmbeginn aufgerufen. Hier sollte Code stehen,
     * der alles vorbereitet, was notwendig für die Programmausführung ist.
     * Zeichenbefehle haben hier keinen Platz.
     */
    public abstract void initialize();

    /**
     * Wird in einer Schleife aufgerufen, solange die GraphicsApp-Anwendung läuft. Hier sollten
     * alle GraphicsObjects aktualisiert und gezeichnet werden.
     */
    public abstract void draw();


    @Override
    public void onMouseMoved(MouseMovedEvent event) {

    }

    @Override
    public void onMousePressed(MousePressedEvent event) {

    }

    @Override
    public void onMouseReleased(MouseReleasedEvent event) {

    }

    @Override
    public void onMouseDragged(MouseDraggedEvent event) {

    }

    /**
     * Wenn Tastendrücke abgefangen werden sollen, muss diese Methode von Kindklassen überschrieben werden
     *
     * @param event Der Tasten-Event, der die Taste enthält, die gedrückt wurde
     */
    @Override
    public void onKeyPressed(KeyPressedEvent event) {

    }

    @Override
    public void onKeyReleased(KeyReleasedEvent event) {

    }

    /**
     * Zeichnet den Hintergrund der GraphicsApp-Anwendung
     *
     * @param color die Hintergrundfarbe
     */
    protected void drawBackground(Color color) {
        if (background == null) {
            background = new Background(getWidth(), getHeight());
        }
        background.setColor(color);
        background.draw();
    }

    /**
     * Setzt die Bildwiederholrate der GraphicsApp-Anwendung
     *
     * @param frameRate Bilder pro Sekunde
     */
    protected void setFrameRate(int frameRate) {
        getConfig().setFrameRate(frameRate);
    }

    /**
     * Zeigt die aktuelle Bildwiederholrate in der Titelleiste der Anwendung an
     */
    protected void showFrameRate() {
        getConfig().setFrameRateVisibility(true);
    }

    public int getWidth() {
        return getConfig().getWidth();
    }

    public int getHeight() {
        return getConfig().getHeight();
    }

    public void setCanvasSize(int width, int height) {
        getConfig().setWidth(width);
        getConfig().setHeight(height);
    }
}
