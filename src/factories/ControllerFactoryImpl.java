package game.factories;

import game.controllers.ControllerImpl;
import game.controllers.Presenter;
import game.controllers.View;
import game.entities.Board;
import game.interactors.createplayer.CreatePlayer;
import game.interactors.createplayer.CreatePlayerPresenter;
import game.interactors.setupgame.SetupGame;
import game.interactors.setupgame.SetupGamePresenter;
import game.manager.Controller;
import game.manager.ControllerFactory;
import game.repositories.PlayerRepositoryImpl;

public class ControllerFactoryImpl implements ControllerFactory {

    static Board board;
    static PlayerRepositoryImpl playerGateway;
    private final View view;
    private final Presenter presenter;

    public ControllerFactoryImpl(View view, Presenter presenter) {
        this.view = view;
        this.presenter = presenter;
    }

    @Override
    public Controller make(String controller) {
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
