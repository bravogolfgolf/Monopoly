package controllers.createBoard;

import interactors.BoardGateway;
import interactors.Request;
import interactors.createboard.CreateBoardInteractor;
import presenters.Presenter;

public class CreateBoardInteractorMock extends CreateBoardInteractor {

    public boolean VerifyHandleMethodCalled = false;

    public CreateBoardInteractorMock(Presenter presenter, BoardGateway gateway) {
        super(presenter, gateway);
    }

    @Override
    public void handle(Request inputRequest) {
        VerifyHandleMethodCalled = true;
    }
}
