package Engine;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public abstract class Game {

    private ArrayList<GameObject> gameObjects;
    private Window window;
    private Canvas canvas;

    public Game(Window window, Canvas canvas) {
        this.window = window;
        this.canvas = canvas;
        this.gameObjects = new ArrayList<>();
        init();
    }

    public final void addGameObject(GameObject gameObject) {
        if (!gameObjects.contains(gameObject)) {
            gameObjects.add(gameObject);
        }

    }

    public final void addCanvasObject(DrawObject drawObject) {
        addGameObject(drawObject);
        canvas.addDrawObject(drawObject);
    }

    public final void startLoop() {
        while (true) {

            process(1f);

            for (GameObject o : gameObjects) {
                o.process(1f);
            }

            canvas.paintImmediately(0, 0, (int)window.getWindowSize().getX(), (int)window.getWindowSize().getY());

            try {
                Thread.sleep((long)16.6);
            } catch (InterruptedException e) {
                System.err.println("Interrupted!: " + e.getMessage());;
            }
        }
    }

    public abstract void init();

    public abstract void process(float delta);

}
