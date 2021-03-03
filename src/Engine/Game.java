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
    }

    public void addGameObject(GameObject gameObject) {
        if (!gameObjects.contains(gameObject)) {
            gameObjects.add(gameObject);
        }
        if (gameObject instanceof DrawObject) {
            draw.addDrawObject((DrawObject)gameObject);
        }

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
        window.setSize((int)windowSize.getX(), (int)windowSize.getY());
        window.setResizable(isResizable);
        window.setVisible(true);
        window.getContentPane().setBackground(backgroundColor);
    }

}
