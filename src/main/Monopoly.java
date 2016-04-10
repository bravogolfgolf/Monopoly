package main;

import controllers.View;
import entitiies.Board;
import factories.ControllerFactoryImpl;
import interactors.BoardGateway;
import interactors.PlayerGateway;
import repositories.PlayerRepository;
import view.Console;

import java.io.IOException;

public final class Monopoly {

    public static View console;
    public static BoardGateway boardGateway;
    public static PlayerGateway playerGateway;
    public static ControllerFactory controllerFactory;

    public static void main(String[] args) throws IOException {
        Monopoly game = new Monopoly();
        game.start();
    }

    private void start() throws IOException {
        console = new Console();
        boardGateway = new Board();
        playerGateway = new PlayerRepository();
        controllerFactory = new ControllerFactoryImpl();

        Controller controller = controllerFactory.make("CreateBoardController");
        controller.execute();
    }
}