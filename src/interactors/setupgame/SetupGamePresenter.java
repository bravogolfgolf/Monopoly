package game.interactors.setupgame;

import game.interactors.InteractorResponse;

public interface SetupGamePresenter {

    void versionCreatedMessage(InteractorResponse response);

    void availableVersionsMessage(InteractorResponse response);
}
