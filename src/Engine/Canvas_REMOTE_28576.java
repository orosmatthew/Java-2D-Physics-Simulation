package Engine;

import Engine.Object.DrawObject;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Canvas extends JComponent {

    private ArrayList<DrawObject> drawObjects = new ArrayList<>();

    public void addDrawObject(DrawObject drawObject) {
        if (!drawObjects.contains(drawObject)) {
            drawObjects.add(drawObject);
        }
    }

    @Override
    public void paint(Graphics g) {
        for (DrawObject o: drawObjects) {
            o.drawObject(g);
        }
    }
}
