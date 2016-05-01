package game.factories;

import game.controllers.*;
import game.display.Console;
import game.entities.Board;
import game.entities.Dice;
import game.interactors.Interactor;
import game.interactors.movetoken.MoveToken;
import game.interactors.partneroptions.PartnerOptions;
import game.interactors.propertyoptions.PropertyOptions;
import game.interactors.selectfirst.SelectFirst;
import game.interactors.tokenoptions.TokenOptionsFewerThanMinimum;
import game.interactors.tokenoptions.TokenOptionsMinimumToMaximum;
import game.interactors.versionoptions.VersionOptions;
import game.manager.ControllerFactory;
import game.presenters.Presenter;
import game.repositories.Players;
import game.repositories.Tokens;

public class ControllerFactoryImpl implements ControllerFactory {

    static Board board;
    static Tokens tokens;
    private final Presenter presenter;
    private final SelectVersionFactoryImpl factory;
    private final Players players;
    private final Console console;


    public ControllerFactoryImpl(Presenter presenter, SelectVersionFactoryImpl factory, Players players, Console console) {
        this.presenter = presenter;
        this.factory = factory;
        this.players = players;
        this.console = console;
    }

    @Override
    public Controller make(String controller) {
        if (controller.equals("VersionOptions")) {
            Interactor interactor = new VersionOptions(presenter, factory);
            return new Options(interactor, presenter, console);
        }

        if (controller.equals("TokenOptionsFewerThanMinimum")) {
            Interactor interactor = new TokenOptionsFewerThanMinimum(presenter, tokens, players);
            return new Options(interactor, presenter, console);
        }

        if (controller.equals("TokenOptionsMinimumToMaximum")) {
            Interactor interactor = new TokenOptionsMinimumToMaximum(presenter, tokens, players);
            return new Options(interactor, presenter, console);
        }

        if (controller.equals("Message")) {
            Interactor interactor = new SelectFirst(presenter, players);
            return new Message(interactor, presenter);
        }

        if (controller.equals("StartTurn")) {
            return new StartTurn(presenter, console);
        }

        if (controller.equals("PropertyOptions")) {
            Interactor interactor = new PropertyOptions(presenter, players);
            return new Options(interactor, presenter, console);
        }

        if (controller.equals("PartnerOptions")) {
            Interactor interactor = new PartnerOptions(presenter, players);
            return new Options(interactor, presenter, console);
        }

        throw new IllegalArgumentException();
    }

    @Override
    public Controller make(String controller, Dice dice) {
        if (controller.equals("MoveToken")) {
            Interactor interactor = new MoveToken(presenter, players, board);
            return new Move(interactor, presenter, dice);
        }

        throw new IllegalArgumentException();
    }
}
