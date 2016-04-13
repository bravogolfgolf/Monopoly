package game;

import game.controllers.View;
import game.factories.ControllerFactoryImpl;
import game.view.Console;

import java.io.IOException;

public final class Monopoly {

    public static View console;
    public static ControllerFactory controllerFactory;

    public static void main(String[] args) throws IOException {
        Monopoly game = new Monopoly();
        game.start();
    }

    private void start() throws IOException {
        console = new Console();
        controllerFactory = new ControllerFactoryImpl();

        Controller controller = controllerFactory.make("CreateBoardController");
        controller.execute();
    }
}