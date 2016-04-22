package game.factories;

import game.Command;
import game.controllers.ControllerImpl;
import game.controllers.Presenter;
import game.controllers.View;
import game.entities.Board;
import game.interactors.createplayer.CreatePlayer;
import game.interactors.createplayer.CreatePlayerPresenter;
import game.interactors.setupgame.SetupGame;
import game.interactors.setupgame.SetupGamePresenter;
import game.repositories.PlayerRepositoryImpl;

public class CommandFactoryImpl {

    static Board board;
    static PlayerRepositoryImpl playerGateway;
    private final View view;
    private final Presenter presenter;

    public CommandFactoryImpl(View view, Presenter presenter) {
        this.view = view;
        this.presenter = presenter;
    }

    public Command make(String controller) {
        if (controller.equals("SetupGame")) {
            SetupGameFactoryImpl factory = new SetupGameFactoryImpl();
            SetupGame interactor = new SetupGame((SetupGamePresenter) presenter, factory);
            return new ControllerImpl(view, interactor, presenter);
        }
        if (controller.equals("CreatePlayer")) {
            CreatePlayer interactor = new CreatePlayer((CreatePlayerPresenter) presenter, playerGateway);
            return new ControllerImpl(view, interactor, presenter);
        }
        throw new IllegalArgumentException();
    }
}
