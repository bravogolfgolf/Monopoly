package presenters.createboard;

import interactors.Response;
import interactors.createboard.CreateBoardResponse;
import presenters.Presenter;

public class CreateBoardPresenter implements Presenter {
    private String viewRequest;

    @Override
    public void present(Response response) {
        this.viewRequest = ((CreateBoardResponse) response).message;
    }

    @Override
    public String getViewRequest() {
        return viewRequest;
    }
}
