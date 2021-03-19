import Engine.Canvas;
import Engine.Game;
import Engine.Window;

public class Java2DPhysicsSimulation extends Game {

    public Java2DPhysicsSimulation(Window window, Canvas canvas) {
        super(window, canvas);
    }

    @Override
    public void init() {
        SquarePrimitive square = new SquarePrimitive();
        addCanvasObject(square);
    }

    @Override
    public void process(double delta) {

    }
}
