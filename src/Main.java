import Engine.Canvas;
import Engine.Type.Vector2;
import Engine.Window;

import java.awt.*;
public class Main {

    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        Window window = new Window(canvas, new Vector2(500, 500), false, Color.BLACK);
        window.createWindow();
        Java2DPhysicsSimulation java2DPhysicsSimulation = new Java2DPhysicsSimulation(window, canvas);
        java2DPhysicsSimulation.startLoop();
    }
}
