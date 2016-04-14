package game;

import game.factories.ControllerFactoryImpl;

import java.io.IOException;

public final class Monopoly {

    public static ControllerFactory factory;

    public static void main(String[] args) throws IOException {
        Monopoly game = new Monopoly();
        game.start();
    }

    private void start() throws IOException {
        factory = new ControllerFactoryImpl();

        Controller controller = factory.make("SetupGameController");
        controller.execute();
    }
}