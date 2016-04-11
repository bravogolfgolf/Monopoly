package game.presenters.createboard;

import game.controllers.Presenter;
import game.interactors.Response;
import game.interactors.createboard.CreateBoardResponse;

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
