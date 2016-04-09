package interactors.createplayer;

import interactors.Response;
import presenters.createplayer.CreatePlayerPresenter;

public class CreatePlayerPresenterMock extends CreatePlayerPresenter {
    public boolean VerifyPresentMethodCalled = false;

    @Override
    public void present(Response response) {
        VerifyPresentMethodCalled = true;
    }

    @Override
    public String getResponse() {
        return null;
    }
}
