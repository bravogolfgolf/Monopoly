package game.doubles;

import game.entities.Banker;
import game.factories.InteractorFactory;
import game.factories.VersionFactory;
import game.presenters.Presenter;

public class InteractorFactoryMock extends InteractorFactory {

    public InteractorFactoryMock(Presenter presenter, VersionFactory factory, Banker banker) {
        super(presenter, factory, banker);
    }
}
