package game;

import game.entitiies.Board;
import game.factories.ControllerFactoryImpl;

import java.io.IOException;

public final class Monopoly {

    public static ControllerFactory factory;
    public static BoardGateway board;

    public static void main(String[] args) throws IOException {
        Monopoly game = new Monopoly();
        game.start();
    }

    private void start() throws IOException {
        factory = new ControllerFactoryImpl();
        board = new Board();

        Controller controller = factory.make("SetupGameController");
        controller.execute();
    }
}