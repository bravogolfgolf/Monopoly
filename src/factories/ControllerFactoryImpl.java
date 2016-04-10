package factories;

import controllers.Controller;
import controllers.createBoard.CreateBoardController;
import controllers.createPlayer.CreatePlayerController;
import interactors.createboard.CreateBoardInteractor;
import interactors.createplayer.CreatePlayerInteractor;
import main.ControllerFactory;
import main.Monopoly;
import main.PlayerGateway;
import presenters.createboard.CreateBoardPresenter;
import presenters.createplayer.CreatePlayerPresenter;
import repositories.PlayerRepository;

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
            PlayerGateway gateway = new PlayerRepository();
            CreatePlayerInteractor interactor = new CreatePlayerInteractor(presenter, gateway);
            return new CreatePlayerController(Monopoly.console, interactor, presenter);
        }
        throw new IllegalArgumentException();
    }
}
