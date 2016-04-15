package game.controllers.setupgame;

import game.controllers.Presenter;
import game.interactors.setupgame.SetupGame;
import game.interactors.setupgame.SetupGameFactory;
import game.interactors.setupgame.SetupGameRequest;

class SetupGameMock extends SetupGame {

    String VerifyRequestValue = "";

    SetupGameMock(Presenter presenter, SetupGameFactory factory) {
        super(presenter, factory);
    }

    @Override
    public void handle(SetupGameRequest request) {
        VerifyRequestValue = request.version;
        super.handle(request);
    }
}
