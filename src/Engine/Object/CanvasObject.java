package Engine.Object;

import Engine.Type.Transform2D;

import java.awt.*;

public abstract class CanvasObject extends GameObject {

    public Transform2D transform = new Transform2D();

    public Transform2D getTransform2D() {
        return transform;
    }

    public void setTransform2D(Transform2D transform) {
        this.transform = transform;
    }

    public void drawObject(Graphics g) {

    }

}
