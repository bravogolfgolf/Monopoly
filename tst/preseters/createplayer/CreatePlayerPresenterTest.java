package game.preseters.createplayer;

import game.interactors.createplayer.CreatePlayerResponse;
import game.presenters.createplayer.CreatePlayerPresenter;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CreatePlayerPresenterTest {

    @Test
    public void validateViewRequest() {
        CreatePlayerResponse response = new CreatePlayerResponse();
        response.message = "CreatePlayerTest";
        CreatePlayerPresenter presenter = new CreatePlayerPresenter();
        presenter.present(response);
        assertTrue(response.message.equals(presenter.getViewRequest()));
    }
}
