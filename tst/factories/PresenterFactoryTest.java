package factories;

import main.Monopoly;
import org.junit.Test;
import presenters.Presenter;

public class PresenterFactoryTest {

    private Presenter presenter;

    @Test(expected = IllegalArgumentException.class)
    public void testPresenterFactoryException() {
        Monopoly.presenterFactory.make("");
    }

    @Test
    public void testCreateInteractors() {
        presenter = Monopoly.presenterFactory.make("CreateBoardPresenter");
        presenter = Monopoly.presenterFactory.make("CreatePlayerPresenter");
    }
}
