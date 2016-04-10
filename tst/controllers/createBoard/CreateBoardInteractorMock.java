package controllers.createBoard;

import controllers.Presenter;
import interactors.BoardGateway;
import interactors.Request;
import interactors.createboard.CreateBoardInteractor;

public class CreateBoardInteractorMock extends CreateBoardInteractor {

    public boolean VerifyHandleMethodCalled = false;

    public CreateBoardInteractorMock(Presenter presenter, BoardGateway gateway) {
        super(presenter, gateway);
    }

    @Override
    public void handle(Request request) {
        VerifyHandleMethodCalled = true;
    }
}
