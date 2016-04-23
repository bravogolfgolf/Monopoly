package game.interactors.gamesetup.createplayer;

import game.interactors.InteractorResponse;

public interface CreatePlayerPresenter  {

    void playerCreatedMessage(InteractorResponse response);

    void availableTokensMessage(InteractorResponse response);
}
