package game.factories;

import game.interactors.Interactor;
import game.interactors.versionoptions.VersionOptions;
import game.presenters.Presenter;

public class InteractorFactory implements ControllerFactoryInteractorFactory {

    private final Presenter presenter;
    private final VersionFactory factory;

    public InteractorFactory(Presenter presenter, VersionFactory factory) {
        this.presenter = presenter;
        this.factory = factory;
    }

    public Interactor make(String interactor) {
        if(interactor.equals("VersionOptions"))
            return new VersionOptions(presenter, factory);

        throw new IllegalArgumentException();
    }
}
