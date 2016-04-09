package presenters.createplayer;

import interactors.Response;
import interactors.createplayer.CreatePlayerResponse;
import presenters.Presenter;

public class CreatePlayerPresenter implements Presenter {
    private String viewResponse;

    @Override
    public void present(Response response) {
        this.viewResponse = ((CreatePlayerResponse) response).message;
    }

    @Override
    public String getResponse() {
        return viewResponse;
    }
}
