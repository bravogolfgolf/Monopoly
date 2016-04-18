package game.interactors.setupgame;

import game.interactors.InteractorPresenter;
import game.interactors.InteractorResponse;

public interface SetupGamePresenter extends InteractorPresenter {

    void setupGamePromptMessage();

    void versionCreatedMessage(InteractorResponse response);

    void availableVersionsMessage(InteractorResponse response);
}
