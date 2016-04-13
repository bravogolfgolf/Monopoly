package game.factories;

import game.Controller;
import game.ControllerFactory;
import game.controllers.Presenter;
import game.controllers.createBoard.CreateBoardController;
import game.controllers.createBoard.CreateBoardControllerInteractor;
import game.controllers.createPlayer.CreatePlayerController;
import game.controllers.createPlayer.CreatePlayerControllerInteractor;
import game.entitiies.Board;
import game.interactors.createboard.CreateBoardGateway;
import game.interactors.createboard.CreateBoardInteractor;
import game.interactors.createplayer.CreatePlayerGateway;
import game.interactors.createplayer.CreatePlayerInteractor;
import game.presenters.PresenterEn;
import game.repositories.CreatePlayerRepository;

import static game.Monopoly.console;

public class ControllerFactoryImpl implements ControllerFactory {

    private final Presenter presenter = new PresenterEn();


    @Override
    public Controller make(String controller) {
        if (controller.equals("CreateBoardController")) {
            CreateBoardGateway board = new Board(new BoardFactoryImpl());
            CreateBoardControllerInteractor interactor = new CreateBoardInteractor(presenter, board);
            return new CreateBoardController(console, interactor, presenter);
        }
        if (controller.equals("CreatePlayerController")) {
            CreatePlayerGateway repository = new CreatePlayerRepository();
            CreatePlayerControllerInteractor interactor = new CreatePlayerInteractor(presenter, repository);
            return new CreatePlayerController(console, interactor, presenter);
        }
        throw new IllegalArgumentException();
    }
}
