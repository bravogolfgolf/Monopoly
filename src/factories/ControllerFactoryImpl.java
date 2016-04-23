package game.factories;

import game.controllers.ControllerImpl;
import game.controllers.ControllerView;
import game.controllers.Presenter;
import game.entities.Board;
import game.interactors.createplayer.CreatePlayer;
import game.interactors.createplayer.CreatePlayerPresenter;
import game.interactors.setupgame.SelectVersion;
import game.interactors.setupgame.SelectVersionPresenter;
import game.manager.Controller;
import game.manager.ControllerFactory;
import game.repositories.PlayerRepositoryImpl;

public class ControllerFactoryImpl implements ControllerFactory {

    static Board board;
    static PlayerRepositoryImpl playerGateway;
    private final ControllerView view;
    private final Presenter presenter;

    public ControllerFactoryImpl(ControllerView view, Presenter presenter) {
        this.view = view;
        this.presenter = presenter;
    }

    @Override
    public Controller make(String controller) {
        if (controller.equals("SelectVersion")) {
            SelectVersionFactoryImpl factory = new SelectVersionFactoryImpl();
            SelectVersion interactor = new SelectVersion((SelectVersionPresenter) presenter, factory);
            return new ControllerImpl(view, interactor, presenter);
        }
        if (controller.equals("CreatePlayer")) {
            CreatePlayer interactor = new CreatePlayer((CreatePlayerPresenter) presenter, playerGateway);
            return new ControllerImpl(view, interactor, presenter);
        }
        throw new IllegalArgumentException();
    }
}
