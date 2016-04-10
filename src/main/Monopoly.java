package main;

import controllers.Controller;
import entitiies.Board;
import factories.ControllerFactoryImpl;
import repositories.PlayerRepository;
import view.Console;

import java.io.IOException;

final class Monopoly {

    public static void main(String[] args) throws IOException {
        Context.console = new Console();
        Context.boardGateway = new Board();
        Context.playerGateway = new PlayerRepository();
        Context.controllerFactory = new ControllerFactoryImpl();

        Controller controller = Context.controllerFactory.make("CreateBoardController");
        controller.execute();
    }
}