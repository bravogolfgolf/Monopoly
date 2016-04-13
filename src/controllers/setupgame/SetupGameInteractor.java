package game.controllers.setupgame;

import game.interactors.setupgame.SetupGameRequest;

public interface SetupGameInteractor {
    void boardPromptAndAvailableBoardsMessages();
    void handle(SetupGameRequest request);
}
