package game.interactors.createplayer;

import game.interactors.InteractorPresenter;
import game.interactors.InteractorResponse;

public interface CreatePlayerPresenter extends InteractorPresenter {

    void playerCreatedMessage(InteractorResponse response);

    void exceededPlayerLimitMessage();

    void createPlayerPromptMessage();

    void availableTokensMessage(InteractorResponse response);
}
