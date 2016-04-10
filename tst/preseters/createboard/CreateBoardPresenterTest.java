package preseters.createboard;

import interactors.createboard.CreateBoardResponse;
import org.junit.Test;
import presenters.createboard.CreateBoardPresenter;

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
