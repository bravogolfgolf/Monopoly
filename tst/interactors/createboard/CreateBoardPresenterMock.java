package game.interactors.createboard;

import game.interactors.Response;
import game.presenters.createboard.CreateBoardPresenter;

public class CreateBoardPresenterMock extends CreateBoardPresenter {

    private String viewRequest;
    public boolean VerifyPresentMethodCalled = false;

    @Override
    public void present(Response response) {
        VerifyPresentMethodCalled = true;
        this.viewRequest = ((CreateBoardResponse) response).message;
    }

    @Override
    public String getViewRequest() {
        return viewRequest;
    }

}
