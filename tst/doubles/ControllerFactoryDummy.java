package game.doubles;

import game.controllers.Controller;
import game.display.Console;
import game.factories.ControllerFactory;
import game.factories.VersionFactory;
import game.presenters.Presenter;
import game.repositories.Players;

public class ControllerFactoryDummy extends ControllerFactory {

    public ControllerFactoryDummy(Presenter presenter, VersionFactory factory, Players players, Console console) {
        super(presenter, factory, players, console);
    }

    @Override
    public Controller make(String controller) {
        return null;
    }
}
