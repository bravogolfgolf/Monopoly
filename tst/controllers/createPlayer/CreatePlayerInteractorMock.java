package game.controllers.createPlayer;

import game.controllers.Presenter;
import game.interactors.createplayer.CreatePlayerGateway;
import game.interactors.createplayer.CreatePlayerInteractor;
import game.interactors.createplayer.CreatePlayerRequest;

class CreatePlayerInteractorMock extends CreatePlayerInteractor {

    boolean VerifyHandleMethodCalled = false;

    CreatePlayerInteractorMock(Presenter presenter, CreatePlayerGateway repository) {
        super(presenter, repository);
    }

    @Override
    public void handle(CreatePlayerRequest request) {
        VerifyHandleMethodCalled = true;
    }

}
