package game.controllers.createPlayer;

import game.controllers.InteractorPresenter;
import game.interactors.PlayerGateway;
import game.interactors.Request;
import game.interactors.createplayer.CreatePlayerInteractor;

public class CreatePlayerInteractorMock extends CreatePlayerInteractor {

    public boolean VerifyHandleMethodCalled = false;

    public CreatePlayerInteractorMock(InteractorPresenter presenter, PlayerGateway gateway) {
        super(presenter, gateway);
    }

    @Override
    public void handle(Request request) {
        VerifyHandleMethodCalled = true;
    }

}
