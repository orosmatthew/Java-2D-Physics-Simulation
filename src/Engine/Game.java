package Engine;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game {

    private JFrame window = new JFrame("Testing");
    private Draw draw = new Draw();
    private ArrayList<GameObject> gameObjects = new ArrayList<>();

    public Game() {
        windowSize = new Vector2(500, 500);
        isResizable = false;
        backgroundColor = Color.BLACK;
        SwingUtilities.updateComponentTreeUI(window);
        window.getContentPane().add(draw);
    }

    public void addGameObject(GameObject gameObject) {
        if (!gameObjects.contains(gameObject)) {
            gameObjects.add(gameObject);
        }
    }

    public void addDrawObject(DrawObject drawObject) {
        addGameObject(drawObject);
        draw.addDrawObject(drawObject);
    }

    private Vector2 windowSize;
    private boolean isResizable;
    private Color backgroundColor;

    public Vector2 getWindowSize() {
        return windowSize;
    }

    public void setWindowSize(Vector2 windowSize) {
        this.windowSize = windowSize;
    }

    public boolean isResizable() {
        return isResizable;
    }

    public void setResizable(boolean resizable) {
        isResizable = resizable;
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public void createWindow() {
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //window.setSize((int)windowSize.getX(), (int)windowSize.getY());
        window.getContentPane().setPreferredSize(new Dimension((int)windowSize.getX(), (int)windowSize.getY()));
        window.pack();
        window.setResizable(isResizable);
        window.setVisible(true);
        window.getContentPane().setBackground(backgroundColor);
    }

    public void startLoop() throws InterruptedException {
        while (true) {
            for (GameObject o : gameObjects) {
                o.process(1f);
            }

            draw.paintImmediately(0, 0, (int)windowSize.getX(), (int)windowSize.getY());

            Thread.sleep((long)16.6);
        }
    }

}
