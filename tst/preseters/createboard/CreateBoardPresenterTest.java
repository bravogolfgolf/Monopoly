package game.preseters.createboard;

import game.interactors.createboard.CreateBoardResponse;
import game.presenters.createboard.CreateBoardPresenter;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CreateBoardPresenterTest {

    @Test
    public void validateViewRequest() {
        CreateBoardPresenter presenter = new CreateBoardPresenter();
        CreateBoardResponse response = new CreateBoardResponse();
        response.message = "CreateBoardTest";
        presenter.present(response);
        assertTrue(response.message.equals(presenter.getViewRequest()));
    }
}
