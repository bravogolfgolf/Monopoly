package main;

import controllers.Controller;
import controllers.ControllerFactory;
import controllers.createBoard.CreateBoardController;
import controllers.createPlayer.CreatePlayerController;

public class ControllerFactoryImpl implements ControllerFactory {

    @Override
    public Controller make(String controller) {
        if (controller.equals("CreateBoardController"))
            return new CreateBoardController();
        if (controller.equals("CreatePlayerController"))
            return new CreatePlayerController();
        throw new IllegalArgumentException();
    }
}
