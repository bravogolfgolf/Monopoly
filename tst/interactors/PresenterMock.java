package game.interactors;

import game.interactors.createplayer.CreatePlayerPresenter;
import game.interactors.createplayer.CreatePlayerResponse;
import game.interactors.options.OptionsPresenter;
import game.interactors.options.OptionsResponse;
import game.interactors.selectfirst.SelectFirstPresenter;
import game.interactors.selectfirst.SelectFirstResponse;
import game.interactors.selectversion.SelectVersionPresenter;
import game.interactors.selectversion.SelectVersionResponse;

class PresenterMock implements SelectVersionPresenter, CreatePlayerPresenter, OptionsPresenter, SelectFirstPresenter {

    boolean verifyVersionCreatedMessage = false;
    boolean verifyPlayerCreatedMessage = false;
    boolean verifyAvailableTokensMessage = false;
    boolean verifyAvailableVersionsMessageCalled = false;
    boolean verifyPlayerSelectedToGoFirstMessage = false;

    @Override
    public void versionCreatedMessage(SelectVersionResponse response) {
        verifyVersionCreatedMessage = true;
    }

    @Override
    public void availableVersionsMessage(OptionsResponse response) {
        verifyAvailableVersionsMessageCalled = true;
    }

    @Override
    public void playerCreatedMessage(CreatePlayerResponse response) {
        verifyPlayerCreatedMessage = true;
    }

    @Override
    public void availableTokensMessage(OptionsResponse response) {
        verifyAvailableTokensMessage = true;
    }

    @Override
    public void playerSelectedToGoFirstMessage(SelectFirstResponse response) {
        verifyPlayerSelectedToGoFirstMessage = true;
    }
}
