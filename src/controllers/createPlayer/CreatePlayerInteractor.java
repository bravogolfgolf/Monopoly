package game.controllers.createPlayer;

import game.interactors.createplayer.CreatePlayerRequest;

public interface CreatePlayerInteractor {
    void handle(CreatePlayerRequest request);
    void createPlayerPrompt();
    void availableTokensMessage();
}
