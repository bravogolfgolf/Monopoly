package game.controllers.setupgame;

import game.interactors.setupgame.SetupGameRequest;

public interface SetupGameInteractor {
    void setupGamePrompt();
    void handle(SetupGameRequest request);
}
