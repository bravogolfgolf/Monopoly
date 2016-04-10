package preseters.createplayer;

import interactors.createplayer.CreatePlayerResponse;
import org.junit.Test;
import presenters.createplayer.CreatePlayerPresenter;

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
