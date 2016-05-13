package game.factories;

import game.controllers.Controller;
import game.controllers.Message;
import game.controllers.Options;
import game.controllers.StartTurn;
import game.display.Console;
import game.interactors.Interactor;
import game.manager.ManagerControllerFactory;
import game.presenters.Presenter;

public class ControllerFactory implements ManagerControllerFactory {

    private final Presenter presenter;
    private final ControllerFactoryInteractorFactory factory;
    private final Console console;

    public ControllerFactory(Presenter presenter, InteractorFactory factory, Console console) {
        this.presenter = presenter;
        this.factory = factory;
        this.console = console;
    }

    @Override
    public Controller make(String type) {
        Interactor interactor;

        if (type.equals("VersionOptions")) {
            interactor = factory.make(type);
            return new Options(interactor, presenter, console);
        }

        if (type.equals("TokenOptionsFewerThanMinimum")) {
            interactor = factory.make(type);
            return new Options(interactor, presenter, console);
        }

        if (type.equals("TokenOptionsMinimumToMaximum")) {
            interactor = factory.make(type);
            return new Options(interactor, presenter, console);
        }

        if (type.equals("Message")) {
            interactor = factory.make(type);
            return new Message(interactor, presenter);
        }

        if (type.equals("StartTurn")) {
            return new StartTurn(presenter, console);
        }

        if (type.equals("RollDice")) {
            interactor = factory.make(type);
            return new Message(interactor, presenter);
        }

        if (type.equals("LandOn")) {
            interactor = factory.make(type);
            return new Message(interactor, presenter);
        }

        if (type.equals("PaySalary")) {
            interactor = factory.make(type);
            return new Message(interactor, presenter);
        }

        if (type.equals("PropertyOptions")) {
            interactor = factory.make(type);
            return new Options(interactor, presenter, console);
        }

        if (type.equals("PartnerOptions")) {
            interactor = factory.make(type);
            return new Options(interactor, presenter, console);
        }

        throw new IllegalArgumentException();
    }
}
