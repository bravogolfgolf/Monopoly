package game;

import game.factories.ControllerFactoryImpl;

import java.io.IOException;

public final class Monopoly {

    public static void main(String[] args) throws IOException {
        Monopoly game = new Monopoly();
        game.start();
    }

    private void start() throws IOException {
        ControllerFactory factory = new ControllerFactoryImpl();

        Controller controller = factory.make("SetupGameController");
        controller.execute();

        controller = factory.make("CreatePlayerController");
        controller.execute();
    }
}