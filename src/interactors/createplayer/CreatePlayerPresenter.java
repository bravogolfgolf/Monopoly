package game.interactors.createplayer;

import game.interactors.InteractorResponse;

public interface CreatePlayerPresenter  {

    void playerCreatedMessage(InteractorResponse response);

    void exceededPlayerLimitMessage();

    void availableTokensMessage(InteractorResponse response);
}
