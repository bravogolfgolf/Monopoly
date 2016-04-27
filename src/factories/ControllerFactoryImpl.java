package game.factories;

import game.controllers.Controller;
import game.controllers.reader.Reader;
import game.controllers.writer.Writer;
import game.controllers.writerreader.WriterReader;
import game.display.Console;
import game.entities.Board;
import game.interactors.createplayer.CreatePlayer;
import game.interactors.propertyoptions.PropertyOptions;
import game.interactors.selectfirst.SelectFirst;
import game.interactors.selectproperty.SelectProperty;
import game.interactors.selectversion.SelectVersion;
import game.interactors.startturn.StartTurn;
import game.interactors.tokenoptions.TokenOptions;
import game.interactors.tokenoptions.TokenOptionsFewerThanMinimum;
import game.interactors.tokenoptions.TokenOptionsMinimumToMaximum;
import game.interactors.versionoptions.VersionOptions;
import game.manager.ControllerFactory;
import game.parser.Parser;
import game.presenters.Presenter;
import game.repositories.Players;
import game.repositories.Tokens;

public class ControllerFactoryImpl implements ControllerFactory {

    static Board board;
    static Tokens tokens;
    private final Parser parser;
    private final Presenter presenter;
    private final SelectVersionFactoryImpl factory;
    private final Players players;
    private final Console console;


    public ControllerFactoryImpl(Parser parser, Presenter presenter, SelectVersionFactoryImpl factory, Players players, Console console) {
        this.parser = parser;
        this.presenter = presenter;
        this.factory = factory;
        this.players = players;
        this.console = console;
    }

    @Override
    public Controller make(String controller) {
        if (controller.equals("VersionOptions")) {
            VersionOptions interactor = new VersionOptions(presenter, factory);
            return new Writer(parser, interactor, presenter, console);
        }

        if (controller.equals("SelectVersion")) {
            SelectVersion interactor = new SelectVersion(presenter, factory);
            return new Reader(interactor, presenter, console);
        }

        if (controller.equals("TokenOptionsFewerThanMinimum")) {
            TokenOptions interactor = new TokenOptionsFewerThanMinimum(presenter, tokens);
            return new Writer(parser, interactor, presenter, console);
        }

        if (controller.equals("TokenOptionsMinimumToMaximum")) {
            TokenOptions interactor = new TokenOptionsMinimumToMaximum(presenter, tokens);
            return new Writer(parser, interactor, presenter, console);
        }

        if (controller.equals("CreatePlayer")) {
            CreatePlayer interactor = new CreatePlayer(presenter, tokens, players);
            return new Reader(interactor, presenter, console);
        }

        if (controller.equals("SelectFirst")) {
            SelectFirst interactor = new SelectFirst(presenter, players);
            return new Writer(parser, interactor, presenter, console);
        }

        if (controller.equals("StartTurn")) {
            StartTurn interactor = new StartTurn(presenter);
            return new WriterReader(interactor, presenter, console);
        }

        if (controller.equals("PropertyOptions")) {
            PropertyOptions interactor = new PropertyOptions(presenter);
            return new Writer(parser, interactor, presenter, console);
        }

        if (controller.equals("SelectProperty")){
            SelectProperty interactor = new SelectProperty(presenter);
            return new Reader(interactor, presenter, console);
        }

        throw new IllegalArgumentException();
    }
}
