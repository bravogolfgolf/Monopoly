package game.interactors;

import game.interactors.createplayer.CreatePlayerPresenter;
import game.interactors.gamesetup.SelectVersionPresenter;
import game.interactors.options.OptionsPresenter;

class PresenterMock implements SelectVersionPresenter, CreatePlayerPresenter, OptionsPresenter {

    boolean verifyVersionCreatedMessage = false;
    boolean verifyPlayerCreatedMessage = false;
    boolean verifyAvailableTokensMessage = false;
    boolean verifyAvailableVersionsMessageCalled = false;

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
