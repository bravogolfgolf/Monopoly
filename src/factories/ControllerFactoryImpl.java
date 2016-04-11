package game.factories;

import game.Controller;
import game.ControllerFactory;
import game.controllers.createBoard.CreateBoardController;
import game.controllers.createPlayer.CreatePlayerController;
import game.interactors.createboard.CreateBoardInteractor;
import game.interactors.createplayer.CreatePlayerInteractor;
import game.presenters.createboard.CreateBoardPresenter;
import game.presenters.createplayer.CreatePlayerPresenter;

import static game.Monopoly.*;

public class ControllerFactoryImpl implements ControllerFactory {


    @Override
    public Controller make(String controller) {
        if (controller.equals("CreateBoardController")) {
            CreateBoardPresenter presenter = new CreateBoardPresenter();
            CreateBoardInteractor interactor = new CreateBoardInteractor(presenter, boardGateway);
            return new CreateBoardController(console, interactor, presenter);
        }
        if (controller.equals("CreatePlayerController")) {
            CreatePlayerPresenter presenter = new CreatePlayerPresenter();
            CreatePlayerInteractor interactor = new CreatePlayerInteractor(presenter, playerGateway);
            return new CreatePlayerController(console, interactor, presenter);
        }
        throw new IllegalArgumentException();
    }
}
