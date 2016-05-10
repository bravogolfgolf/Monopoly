package game.doubles;

import game.factories.InteractorFactory;
import game.factories.VersionFactory;
import game.presenters.Presenter;

public class InteractorFactoryMock extends InteractorFactory {

    public InteractorFactoryMock(Presenter presenter, VersionFactory factory) {
        super(presenter, factory);
    }
}
