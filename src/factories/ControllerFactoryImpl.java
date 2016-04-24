package game.factories;

import game.controllers.Basic;
import game.controllers.SetMap;
import game.entities.Board;
import game.entities.Players;
import game.entities.Tokens;
import game.interactors.createplayer.CreatePlayer;
import game.interactors.options.Options;
import game.interactors.selectfirst.SelectFirst;
import game.interactors.selectversion.SelectVersion;
import game.manager.ControllerFactory;
import game.manager.ManagerController;
import game.presenters.PresenterEn;
import game.view.View;

public class ControllerFactoryImpl implements ControllerFactory {

    static Board board;
    static Tokens tokens;
    private final View view;
    private final PresenterEn presenter;
    private final SelectVersionFactoryImpl factory;
    private final Players players;

    public ControllerFactoryImpl(View view, PresenterEn presenter, SelectVersionFactoryImpl factory, Players players) {
        this.view = view;
        this.presenter = presenter;
        this.factory = factory;
        this.players = players;
    }

    @Override
    public ManagerController make(String controller) {

        if (controller.equals("SelectVersion")) {
            SelectVersion interactor = new SelectVersion(presenter, factory);
            return new Basic(view, interactor, presenter);
        }

        if (controller.equals("CreatePlayer")) {
            CreatePlayer interactor = new CreatePlayer(presenter, tokens, players);
            return new Basic(view, interactor, presenter);
        }

        if (controller.equals("Options")) {
            Options interactor = new Options(presenter, factory, tokens);
            return new SetMap(view, interactor, presenter);
        }

        if (controller.equals("SelectFirst")) {
            SelectFirst interactor = new SelectFirst(presenter, players);
            return new Basic(view, interactor, presenter);
        }

        throw new IllegalArgumentException();
    }
}
