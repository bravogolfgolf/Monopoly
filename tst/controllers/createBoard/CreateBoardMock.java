package game.controllers.createBoard;

import game.controllers.Presenter;
import game.interactors.createboard.CreateBoard;
import game.interactors.createboard.CreateBoardGateway;
import game.interactors.createboard.CreateBoardRequest;

class CreateBoardMock extends CreateBoard {

    boolean VerifyHandleMethodCalled = false;

    CreateBoardMock(Presenter presenter, CreateBoardGateway board) {
        super(presenter, board);
    }

    @Override
    public void handle(CreateBoardRequest request) {
        VerifyHandleMethodCalled = true;
    }
}
