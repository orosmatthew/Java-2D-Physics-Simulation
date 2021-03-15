import Engine.Object.CanvasObject;
import Engine.Type.Vector2;

import java.awt.*;

public class SquarePrimitive extends CanvasObject {

    private Vector2 position;
    private Vector2 size;

    public SquarePrimitive(Vector2 position, Vector2 size) {
        this.position = position;
        this.size = size;
    }

    public SquarePrimitive() {
        this(new Vector2(), new Vector2(1, 1));
    }

    @Override
    public void drawObject(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect((int)position.getX(), (int)position.getY(), (int)size.getX(), (int)size.getY());
    }

    @Override
    public void init() {

    }

    @Override
    public void process(double delta) {
        position.setX((float)(position.getX() + (0.1 * delta)));
    }
}
