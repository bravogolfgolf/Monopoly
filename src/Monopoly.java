package game;

import game.controllers.View;
import game.entitiies.Board;
import game.factories.BoardFactoryImpl;
import game.factories.ControllerFactoryImpl;
import game.interactors.BoardFactory;
import game.interactors.BoardGateway;
import game.interactors.PlayerGateway;
import game.repositories.PlayerRepository;
import game.view.Console;

import java.io.IOException;

public final class Monopoly {

    public static View console;
    public static BoardGateway boardGateway;
    public static PlayerGateway playerGateway;
    public static BoardFactory boardFactory;
    public static ControllerFactory controllerFactory;

    public static void main(String[] args) throws IOException {
        Monopoly game = new Monopoly();
        game.start();
    }

    private void start() throws IOException {
        console = new Console();
        boardGateway = new Board();
        playerGateway = new PlayerRepository();
        boardFactory = new BoardFactoryImpl();
        controllerFactory = new ControllerFactoryImpl();

        Controller controller = controllerFactory.make("CreateBoardController");
        controller.execute();
    }
}