package game.factories;

import game.interactors.Interactor;

public interface ControllerFactoryInteractorFactory {

    Interactor make(String interactor);
}
