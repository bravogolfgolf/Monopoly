package game.controllers.createBoard;

import game.controllers.InteractorPresenter;
import game.interactors.BoardGateway;
import game.interactors.Request;
import game.interactors.createboard.CreateBoardInteractor;

public class CreateBoardInteractorMock extends CreateBoardInteractor {

    public boolean VerifyHandleMethodCalled = false;

    public CreateBoardInteractorMock(InteractorPresenter presenter, BoardGateway gateway) {
        super(presenter, gateway);
    }

    @Override
    public void handle(Request request) {
        VerifyHandleMethodCalled = true;
    }
}
