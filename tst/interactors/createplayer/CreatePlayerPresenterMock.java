package interactors.createplayer;

import interactors.Response;
import presenters.createplayer.CreatePlayerPresenter;

public class CreatePlayerPresenterMock extends CreatePlayerPresenter {

    public boolean VerifyPresentMethodCalled = false;
    private String viewRequest;

    @Override
    public void present(Response response) {
        VerifyPresentMethodCalled = true;
        this.viewRequest = ((CreatePlayerResponse) response).message;
    }

    @Override
    public String getViewRequest() {
        return viewRequest;
    }

}
