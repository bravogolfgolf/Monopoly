package game;

import game.entitiies.Board;
import game.factories.ControllerFactoryImpl;
import game.repositories.PlayerRepositoryImpl;

import java.io.IOException;

public final class Monopoly {

    public static Board board;
    public static PlayerRepositoryImpl playerGateway;

    public static void main(String[] args) throws IOException {

        Monopoly monopoly = new Monopoly();
        monopoly.start();
    }

    private void start() throws IOException {

        ControllerFactoryImpl factory = new ControllerFactoryImpl();

        Controller controller = factory.make("SetupGame");
        controller.execute();

        controller = factory.make("CreatePlayer");
        controller.execute();
    }
}