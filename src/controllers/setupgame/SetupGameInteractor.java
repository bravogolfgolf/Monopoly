package game.controllers.setupgame;

import game.interactors.setupgame.SetupGameRequest;

public interface SetupGameInteractor {
    void handle(SetupGameRequest request);
    void setupGamePrompt();
    void availableVersionsMessage();
}
