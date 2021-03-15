import Engine.Canvas;
import Engine.Game;
import Engine.Type.Vector2;
import Engine.Window;

public class Java2DPhysicsSimulation extends Game {

    public Java2DPhysicsSimulation(Window window, Canvas canvas) {
        super(window, canvas);
    }

    @Override
    public void init() {
        SquarePrimitive square = new SquarePrimitive(new Vector2(0, 0), new Vector2(300, 300));
        addCanvasObject(square);
    }

    @Override
    public void process(float delta) {

    }
}
