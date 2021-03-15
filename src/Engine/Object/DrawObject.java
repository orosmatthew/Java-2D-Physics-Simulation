package Engine.Object;

import Engine.Type.Vector2;

import java.awt.*;

public abstract class DrawObject extends GameObject {

    private Vector2 position = new Vector2();

    public abstract void drawObject(Graphics g);

}
