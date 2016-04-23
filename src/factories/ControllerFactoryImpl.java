package game.factories;

import game.controllers.Controller;
import game.controllers.ControllerPresenter;
import game.controllers.ControllerView;
import game.entities.Board;
import game.entities.Players;
import game.interactors.createplayer.CreatePlayer;
import game.interactors.createplayer.CreatePlayerPresenter;
import game.interactors.selectversion.SelectVersion;
import game.interactors.selectversion.SelectVersionPresenter;
import game.manager.ControllerFactory;
import game.manager.ManagerController;

public class ControllerFactoryImpl implements ControllerFactory {

    static Board board;
    static Players players;
    private final ControllerView view;
    private final ControllerPresenter presenter;

    public ControllerFactoryImpl(ControllerView view, ControllerPresenter presenter) {
        this.view = view;
        this.presenter = presenter;
    }

    @Override
    public ManagerController make(String controller) {
        if (controller.equals("SelectVersion")) {
            SelectVersionFactoryImpl factory = new SelectVersionFactoryImpl();
            SelectVersion interactor = new SelectVersion((SelectVersionPresenter) presenter, factory);
            return new Controller(view, interactor, presenter);
        }
        if (controller.equals("CreatePlayer")) {
            CreatePlayer interactor = new CreatePlayer((CreatePlayerPresenter) presenter, players);
            return new Controller(view, interactor, presenter);
        }
        throw new IllegalArgumentException();
    }
}
