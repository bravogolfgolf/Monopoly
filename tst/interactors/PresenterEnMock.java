package game.interactors;

import game.interactors.gamesetup.createplayer.CreatePlayerPresenter;
import game.interactors.gamesetup.selectversion.SelectVersionPresenter;

public class PresenterEnMock implements SelectVersionPresenter, CreatePlayerPresenter {

    public boolean verifyVersionCreatedMessage = false;
    public boolean verifyPlayerCreatedMessage = false;
    public boolean verifyAvailableTokensMessage = false;
    public boolean verifyAvailableVersionsMessageCalled=false;

    @Override
    public void versionCreatedMessage(InteractorResponse response) {
        verifyVersionCreatedMessage = true;
    }

    @Override
    public void availableVersionsMessage(InteractorResponse response) {
        verifyAvailableVersionsMessageCalled = true;
    }

    @Override
    public void playerCreatedMessage(InteractorResponse response) {
        verifyPlayerCreatedMessage = true;
    }

    @Override
    public void availableTokensMessage(InteractorResponse response) {
        verifyAvailableTokensMessage = true;
    }
}
