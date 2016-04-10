package factories;

import controllers.createBoard.CreateBoardController;
import controllers.createPlayer.CreatePlayerController;
import interactors.createboard.CreateBoardInteractor;
import interactors.createplayer.CreatePlayerInteractor;
import main.Controller;
import main.ControllerFactory;
import main.Monopoly;
import presenters.createboard.CreateBoardPresenter;
import presenters.createplayer.CreatePlayerPresenter;

public class ControllerFactoryImpl implements ControllerFactory {


    @Override
    public Controller make(String controller) {
        if (controller.equals("CreateBoardController")) {
            CreateBoardPresenter presenter = new CreateBoardPresenter();
            CreateBoardInteractor interactor = new CreateBoardInteractor(presenter, Monopoly.boardGateway);
            return new CreateBoardController(Monopoly.console, interactor, presenter);
        }
        if (controller.equals("CreatePlayerController")) {
            CreatePlayerPresenter presenter = new CreatePlayerPresenter();
            CreatePlayerInteractor interactor = new CreatePlayerInteractor(presenter, Monopoly.playerGateway);
            return new CreatePlayerController(Monopoly.console, interactor, presenter);
        }
        throw new IllegalArgumentException();
    }
}
