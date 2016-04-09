package main;

import presenters.Presenter;
import presenters.PresenterFactory;
import presenters.createboard.CreateBoardPresenterSpy;
import presenters.createplayer.CreatePlayerPresenterSpy;

public class PresenterFactoryImpl implements PresenterFactory {

    @Override
    public Presenter make(String presenter) {
        if (presenter.equals("CreateBoardPresenterSpy"))
            return new CreateBoardPresenterSpy();
        if (presenter.equals("CreatePlayerPresenterSpy"))
            return new CreatePlayerPresenterSpy();
        throw new IllegalArgumentException();
    }
}
