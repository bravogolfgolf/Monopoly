package game.controllers.createBoard;

import game.controllers.Presenter;
import game.interactors.createboard.CreateBoardGateway;
import game.interactors.createboard.CreateBoardInteractor;
import game.interactors.createboard.CreateBoardRequest;

class CreateBoardInteractorMock extends CreateBoardInteractor {

    boolean VerifyHandleMethodCalled = false;

    CreateBoardInteractorMock(Presenter presenter, CreateBoardGateway board) {
        super(presenter, board);
    }

    @Override
    public void handle(CreateBoardRequest request) {
        VerifyHandleMethodCalled = true;
    }
}
