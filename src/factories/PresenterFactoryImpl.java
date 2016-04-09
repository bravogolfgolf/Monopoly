package factories;

import main.PresenterFactory;
import presenters.Presenter;
import presenters.createboard.CreateBoardPresenter;
import presenters.createplayer.CreatePlayerPresenter;

public class PresenterFactoryImpl implements PresenterFactory {

    @Override
    public Presenter make(String presenter) {
        if (presenter.equals("CreateBoardPresenter")) {
            return new CreateBoardPresenter();
        }
        if (presenter.equals("CreatePlayerPresenter")) {
            return new CreatePlayerPresenter();
        }
        throw new IllegalArgumentException();
    }
}
