package controllers.createPlayer;

import interactors.Request;
import interactors.createplayer.CreatePlayerInteractor;
import main.PlayerGateway;
import presenters.Presenter;

public class CreatePlayerInteractorMock extends CreatePlayerInteractor {

    public boolean VerifyInteractorWasCalledCorrectly = false;

    public CreatePlayerInteractorMock(Presenter presenter, PlayerGateway gateway) {
        super(presenter, gateway);
    }

    @Override
    public void handle(Request inputRequest) {
        VerifyInteractorWasCalledCorrectly = true;
    }

}
