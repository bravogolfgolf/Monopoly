package factories;

import controllers.Controller;
import controllers.View;
import controllers.createBoard.CreateBoardController;
import controllers.createPlayer.CreatePlayerController;
import interactors.createboard.CreateBoardInteractor;
import interactors.createplayer.CreatePlayerInteractor;
import main.ControllerFactory;
import main.PlayerGateway;
import main.monopoly;
import presenters.createboard.CreateBoardPresenter;
import presenters.createplayer.CreatePlayerPresenter;
import repositories.PlayerRepository;
import view.Console;

public class ControllerFactoryImpl implements ControllerFactory {
    private final View view = new Console();

    @Override
    public Controller make(String controller) {
        if (controller.equals("CreateBoardController")) {
            CreateBoardPresenter presenter = new CreateBoardPresenter();
            CreateBoardInteractor interactor = new CreateBoardInteractor(presenter, monopoly.boardGateway);
            return new CreateBoardController(view, interactor, presenter);
        }
        if (controller.equals("CreatePlayerController")) {
            CreatePlayerPresenter presenter = new CreatePlayerPresenter();
            PlayerGateway gateway = new PlayerRepository();
            CreatePlayerInteractor interactor = new CreatePlayerInteractor(presenter, gateway);
            return new CreatePlayerController(view, interactor, presenter);
        }
        throw new IllegalArgumentException();
    }
}
