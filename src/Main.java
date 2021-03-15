import Engine.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();
        game.createWindow();
        SquarePrimitive square = new SquarePrimitive(new Vector2(0, 0), new Vector2(50, 50));
        game.addDrawObject(square);
        game.loop();
    }
}
