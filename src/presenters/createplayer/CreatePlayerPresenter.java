package presenters.createplayer;

import interactors.Response;
import interactors.createplayer.CreatePlayerResponse;
import presenters.Presenter;

public class CreatePlayerPresenter implements Presenter {
    private String viewRequest;

    @Override
    public void present(Response response) {
        this.viewRequest = ((CreatePlayerResponse) response).message;
    }

    @Override
    public String getViewRequest() {
        return viewRequest;
    }
}
