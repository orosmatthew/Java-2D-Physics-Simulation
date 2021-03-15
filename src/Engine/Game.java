package Engine;

import Engine.Object.CanvasObject;
import Engine.Object.GameObject;

import java.util.ArrayList;

public abstract class Game {

    private ArrayList<GameObject> gameObjects;
    private Window window;
    private Canvas canvas;
    private boolean isRunning;
    private final int FPS = 144;
    private final int UPS = 60;
    private boolean isPrintingTimings;

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
    public void addDrawObject(CanvasObject canvasObject) {
        addGameObject(canvasObject);
        canvas.addDrawObject(canvasObject);

    }

    public final void addCanvasObject(CanvasObject canvasObject) {
        addGameObject(canvasObject);
        canvas.addDrawObject(canvasObject);
    }

    public final void stopLoop() {
        isRunning = false;
    }

    public final void startLoop() {

        isRunning = true;

        long initialTime = System.nanoTime();
        final double timeU = 1000000000 / UPS;
        final double timeF = 1000000000 / FPS;
        double deltaU = 0, deltaF = 0;
        int frames = 0, ticks = 0;
        long timer = System.currentTimeMillis();

        while (isRunning) {

            long currentTime = System.nanoTime();
            deltaU += (currentTime - initialTime) / timeU;
            deltaF += (currentTime - initialTime) / timeF;
            initialTime = currentTime;

            if (deltaU >= 1) {
                update(deltaU);
                ticks++;
                deltaU--;
            }

            if (deltaF >= 1) {
                render(deltaF);
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - timer > 1000) {
                if (isPrintingTimings) {
                    System.out.println(String.format("Update Rate: %s, Framerate: %s", ticks, frames));
                }
                frames = 0;
                ticks = 0;
                timer += 1000;
            }
        }
    }
    private final void update(double delta) {

        process(delta);

        for (GameObject o : gameObjects) {
            o.process(delta);
        }

    }

    private final void render(double delta) {
        canvas.paintImmediately(0, 0, (int)window.getWindowSize().getX(), (int)window.getWindowSize().getY());
    }

    public abstract void init();

    public abstract void process(double delta);

}
