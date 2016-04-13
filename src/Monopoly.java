package game;

import game.factories.ControllerFactoryImpl;

import java.io.IOException;

public final class Monopoly {

    public static ControllerFactory controllerFactory;

    public static void main(String[] args) throws IOException {
        Monopoly game = new Monopoly();
        game.start();
    }

    private void start() throws IOException {
        controllerFactory = new ControllerFactoryImpl();

        Controller controller = controllerFactory.make("SetupGameController");
        controller.execute();
    }
}