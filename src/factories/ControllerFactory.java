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
import game.manager.ManagerControllerFactory;
import game.presenters.Presenter;
import game.repositories.Players;

import static game.Context.*;

public class ControllerFactory implements ManagerControllerFactory {

    private final Presenter presenter;
    private final ControllerFactoryInteractorFactory factory;
    private final Console console;
    private final Banker banker = new Banker();

    public ControllerFactory(Presenter presenter, InteractorFactory factory, Players players, Console console) {
        this.presenter = presenter;
        this.factory = factory;
        Context.players = players;
        this.console = console;
    }

    @Override
    public Controller make(String controller) {
        Interactor interactor;

        if (controller.equals("VersionOptions")) {
            interactor = factory.make(controller);
            return new Options(interactor, presenter, console);
        }

        if (controller.equals("TokenOptionsFewerThanMinimum")) {
            interactor = new TokenOptionsFewerThanMinimum(presenter, tokens, players, board);
            return new Options(interactor, presenter, console);
        }

        if (controller.equals("TokenOptionsMinimumToMaximum")) {
            interactor = new TokenOptionsMinimumToMaximum(presenter, tokens, players, board);
            return new Options(interactor, presenter, console);
        }

        if (controller.equals("Message")) {
            interactor = new SelectFirst(presenter, players);
            return new Message(interactor, presenter);
        }

        if (controller.equals("StartTurn")) {
            return new StartTurn(presenter, console);
        }

        if (controller.equals("MoveToken")) {
            interactor = new MoveToken(presenter, board);
            return new Message(interactor, presenter);
        }

        if (controller.equals("PassGo")) {
            interactor = new PassGo(presenter, banker, board);
            return new Message(interactor, presenter);
        }

        if (controller.equals("PropertyOptions")) {
            interactor = new PropertyOptions(presenter);
            return new Options(interactor, presenter, console);
        }

        if (controller.equals("PartnerOptions")) {
            interactor = new PartnerOptions(presenter, players);
            return new Options(interactor, presenter, console);
        }

        throw new IllegalArgumentException();
    }
}
