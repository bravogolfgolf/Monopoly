package controllers.createBoard;

import interactors.Request;
import interactors.createboard.CreateBoardInteractor;
import main.BoardGateway;
import presenters.Presenter;

public class CreateBoardInteractorMock extends CreateBoardInteractor {

    public boolean VerifyInteractorWasCalledCorrectly = false;

    public CreateBoardInteractorMock(Presenter presenter, BoardGateway gateway) {
        super(presenter, gateway);
    }

    @Override
    public void handle(Request inputRequest) {
        VerifyInteractorWasCalledCorrectly = true;
    }
}
