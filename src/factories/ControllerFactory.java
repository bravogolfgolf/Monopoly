package game.factories;

import game.Context;
import game.controllers.Controller;
import game.controllers.Message;
import game.controllers.Options;
import game.controllers.StartTurn;
import game.display.Console;
import game.entities.Banker;
import game.interactors.Interactor;
import game.interactors.movetoken.MoveToken;
import game.interactors.partneroptions.PartnerOptions;
import game.interactors.passgo.PassGo;
import game.interactors.propertyoptions.PropertyOptions;
import game.interactors.selectfirst.SelectFirst;
import game.interactors.tokenoptions.TokenOptionsFewerThanMinimum;
import game.interactors.tokenoptions.TokenOptionsMinimumToMaximum;
import game.interactors.versionoptions.VersionOptions;
import game.manager.ManagerControllerFactory;
import game.presenters.Presenter;
import game.repositories.Players;

import static game.Context.*;

public class ControllerFactory implements ManagerControllerFactory {

    private final Presenter presenter;
    private final VersionFactory factory;
    private final Console console;
    private final Banker banker = new Banker();

    public ControllerFactory(Presenter presenter, VersionFactory factory, Players players, Console console) {
        this.presenter = presenter;
        this.factory = factory;
        Context.players = players;
        this.console = console;
    }

    @Override
    public Controller make(String controller) {
        if (controller.equals("VersionOptions")) {
            Interactor interactor = new VersionOptions(presenter, factory);
            return new Options(interactor, presenter, console);
        }

        if (controller.equals("TokenOptionsFewerThanMinimum")) {
            Interactor interactor = new TokenOptionsFewerThanMinimum(presenter, tokens, players, board);
            return new Options(interactor, presenter, console);
        }

        if (controller.equals("TokenOptionsMinimumToMaximum")) {
            Interactor interactor = new TokenOptionsMinimumToMaximum(presenter, tokens, players, board);
            return new Options(interactor, presenter, console);
        }

        if (controller.equals("Message")) {
            Interactor interactor = new SelectFirst(presenter, players);
            return new Message(interactor, presenter);
        }

        if (controller.equals("StartTurn")) {
            return new StartTurn(presenter, console);
        }

        if (controller.equals("MoveToken")) {
            Interactor interactor = new MoveToken(presenter, board);
            return new Message(interactor, presenter);
        }

        if (controller.equals("PassGo")) {
            Interactor interactor = new PassGo(presenter, banker, board);
            return new Message(interactor, presenter);
        }

        if (controller.equals("PropertyOptions")) {
            Interactor interactor = new PropertyOptions(presenter);
            return new Options(interactor, presenter, console);
        }

        if (controller.equals("PartnerOptions")) {
            Interactor interactor = new PartnerOptions(presenter, players);
            return new Options(interactor, presenter, console);
        }

        throw new IllegalArgumentException();
    }
}
