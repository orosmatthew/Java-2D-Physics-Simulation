import Engine.Game;
import Engine.SquarePrimitive;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        game.createWindow();
        SquarePrimitive square = new SquarePrimitive();
        game.addGameObject(square);
    }
}
