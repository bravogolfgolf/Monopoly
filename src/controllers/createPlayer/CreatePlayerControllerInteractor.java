package game.controllers.createPlayer;

import game.interactors.createplayer.CreatePlayerRequest;

public interface CreatePlayerControllerInteractor {
    void handle(CreatePlayerRequest request);
}
