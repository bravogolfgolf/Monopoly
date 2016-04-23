package game.factories;

import game.controllers.Basic;
import game.controllers.ControllerPresenter;
import game.controllers.ControllerView;
import game.controllers.SetMap;
import game.entities.Board;
import game.entities.Players;
import game.interactors.createplayer.CreatePlayer;
import game.interactors.createplayer.CreatePlayerPresenter;
import game.interactors.gamesetup.SelectVersion;
import game.interactors.gamesetup.SelectVersionPresenter;
import game.interactors.options.Options;
import game.interactors.options.OptionsPresenter;
import game.manager.ControllerFactory;
import game.manager.ManagerController;

public class ControllerFactoryImpl implements ControllerFactory {

    static Board board;
    static Players players;
    private final ControllerView view;
    private final ControllerPresenter presenter;
    private final SelectVersionFactoryImpl factory = new SelectVersionFactoryImpl();

    public ControllerFactoryImpl(ControllerView view, ControllerPresenter presenter) {
        this.view = view;
        this.presenter = presenter;
    }

    @Override
    public ManagerController make(String controller) {

        if (controller.equals("SelectVersion")) {
            SelectVersion interactor = new SelectVersion((SelectVersionPresenter) presenter, factory);
            return new Basic(view, interactor, presenter);
        }
        if (controller.equals("CreatePlayer")) {
            CreatePlayer interactor = new CreatePlayer((CreatePlayerPresenter) presenter, players);
            return new Basic(view, interactor, presenter);
        }
        if (controller.equals("Options")) {
            Options interactor = new Options((OptionsPresenter) presenter, factory, players);
            return new SetMap(view, interactor, presenter);
        }
        throw new IllegalArgumentException();
    }
}
