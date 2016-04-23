package game.interactors.gamesetup.selectversion;

import game.interactors.InteractorResponse;

public interface SelectVersionPresenter {

    void versionCreatedMessage(InteractorResponse response);

    void availableVersionsMessage(InteractorResponse response);
}
