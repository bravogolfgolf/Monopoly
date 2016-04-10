package controllers.createPlayer;

import controllers.Presenter;
import interactors.PlayerGateway;
import interactors.Request;
import interactors.createplayer.CreatePlayerInteractor;

public class CreatePlayerInteractorMock extends CreatePlayerInteractor {

    public boolean VerifyHandleMethodCalled = false;

    public CreatePlayerInteractorMock(Presenter presenter, PlayerGateway gateway) {
        super(presenter, gateway);
    }

    @Override
    public void handle(Request request) {
        VerifyHandleMethodCalled = true;
    }

}
