package game.controllers.createBoard;

import game.controllers.Presenter;
import game.interactors.BoardGateway;
import game.interactors.Request;
import game.interactors.createboard.CreateBoardInteractor;

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
