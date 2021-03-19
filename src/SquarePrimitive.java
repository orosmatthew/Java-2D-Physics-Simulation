import Engine.Object.CanvasObject;
import Engine.Type.Vector2;

import java.awt.*;

public class SquarePrimitive extends CanvasObject {

    @Override
    public void drawObject(Graphics g) {
        g.setColor(Color.RED);
        int[] xPoints = {0, 0, 100, 100};
        int[] yPoints = {0, 100, 100, 0};
        Polygon polygon = new Polygon(xPoints, yPoints, 4);
        polygon = getTransform2D().transformPolygon(polygon);
        g.fillPolygon(polygon);
    }

    @Override
    public void init() {

    }

    @Override
    public void process(double delta) {
        transform.translate(new Vector2(0, 0.1f));
    }
}
