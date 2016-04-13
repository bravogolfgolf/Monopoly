package game.controllers.setupgame;

import game.controllers.Presenter;
import game.interactors.setupgame.SetupGame;
import game.interactors.setupgame.SetupGameGateway;
import game.interactors.setupgame.SetupGameRequest;

class SetupGameMock extends SetupGame {

    boolean VerifyHandleMethodCalled = false;

    SetupGameMock(Presenter presenter, SetupGameGateway board) {
        super(presenter, board);
    }

    @Override
    public void handle(SetupGameRequest request) {
        VerifyHandleMethodCalled = true;
    }
}
