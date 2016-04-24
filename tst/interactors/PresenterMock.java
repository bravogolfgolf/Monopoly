package game.interactors;

import game.interactors.createplayer.CreatePlayerPresenter;
import game.interactors.options.OptionsPresenter;
import game.interactors.selectfirst.SelectFirstPresenter;
import game.interactors.selectversion.SelectVersionPresenter;

class PresenterMock implements SelectVersionPresenter, CreatePlayerPresenter, OptionsPresenter, SelectFirstPresenter {

    boolean verifyVersionCreatedMessage = false;
    boolean verifyPlayerCreatedMessage = false;
    boolean verifyAvailableTokensMessage = false;
    boolean verifyAvailableVersionsMessageCalled = false;
    boolean verifyPlayerSelectedToGoFirstMessage = false;

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

    @Override
    public void playerSelectedToGoFirstMessage(InteractorResponse response) {
        verifyPlayerSelectedToGoFirstMessage = true;
    }
}
