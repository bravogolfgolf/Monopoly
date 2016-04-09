package interactors.createboard;

import interactors.Response;
import presenters.createboard.CreateBoardPresenter;

public class CreateBoardPresenterMock extends CreateBoardPresenter {
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
