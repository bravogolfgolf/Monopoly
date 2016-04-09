package presenters.createboard;

import interactors.Response;
import interactors.createboard.CreateBoardResponse;
import presenters.Presenter;

public class CreateBoardPresenter implements Presenter {
    private String viewResponse;

    @Override
    public void present(Response response) {
        this.viewResponse = ((CreateBoardResponse) response).message;
    }

    @Override
    public String getResponse() {
        return viewResponse;
    }
}
