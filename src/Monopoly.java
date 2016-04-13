package game;

import game.controllers.View;
import game.factories.ControllerFactoryImpl;
import game.view.Console;

import java.io.*;

public final class Monopoly {

    public static View console;
    public static ControllerFactory controllerFactory;

    public static void main(String[] args) throws IOException {
        Monopoly game = new Monopoly();
        game.start();
    }

    private void start() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        console = new Console(reader, writer);
        controllerFactory = new ControllerFactoryImpl();

        Controller controller = controllerFactory.make("CreateBoardController");
        controller.execute();
    }
}