package game.factories;

import game.controllers.Controller;
import game.controllers.basic.Basic;
import game.controllers.setmap.Menu;
import game.entities.Board;
import game.interactors.createplayer.CreatePlayer;
import game.interactors.options.VersionOptions;
import game.interactors.selectfirst.SelectFirst;
import game.interactors.selectversion.SelectVersion;
import game.interactors.tokenoptions.TokenOptions;
import game.manager.ControllerFactory;
import game.parser.ControllerConsole;
import game.parser.Parser;
import game.presenters.PresenterEn;
import game.repositories.Players;
import game.repositories.Tokens;

public class ControllerFactoryImpl implements ControllerFactory {

    static Board board;
    static Tokens tokens;
    private final Parser parser;
    private final PresenterEn presenter;
    private final SelectVersionFactoryImpl factory;
    private final Players players;
    private final ControllerConsole console;


    public ControllerFactoryImpl(Parser parser, PresenterEn presenter, SelectVersionFactoryImpl factory, Players players, ControllerConsole console) {
        this.parser = parser;
        this.presenter = presenter;
        this.factory = factory;
        this.players = players;
        this.console = console;
    }

    @Override
    public Controller make(String controller) {

        if (controller.equals("SelectVersion")) {
            SelectVersion interactor = new SelectVersion(presenter, factory);
            return new Basic(interactor, presenter, console);
        }

        if (controller.equals("VersionOptions")) {
            VersionOptions interactor = new VersionOptions(presenter, factory);
            return new Menu(parser, interactor, presenter, console);
        }

        if (controller.equals("CreatePlayer")) {
            CreatePlayer interactor = new CreatePlayer(presenter, tokens, players);
            return new Basic(interactor, presenter, console);
        }

        if (controller.equals("TokenOptions")) {
            TokenOptions interactor = new TokenOptions(presenter, tokens);
            return new Menu(parser, interactor, presenter, console);
        }

        if (controller.equals("SelectFirst")) {
            SelectFirst interactor = new SelectFirst(presenter, players);
            return new Menu(parser, interactor, presenter, console);
        }

        throw new IllegalArgumentException();
    }
}
