package game.interactors;

import game.interactors.createplayer.CreatePlayerPresenter;
import game.interactors.createplayer.CreatePlayerResponse;
import game.interactors.options.VersionOptionsPresenter;
import game.interactors.options.VersionOptionsResponse;
import game.interactors.selectfirst.SelectFirstPresenter;
import game.interactors.selectfirst.SelectFirstResponse;
import game.interactors.selectversion.SelectVersionPresenter;
import game.interactors.selectversion.SelectVersionResponse;
import game.interactors.tokenoptions.TokenOptionsPresenter;
import game.interactors.tokenoptions.TokenOptionsResponse;

class PresenterMock implements SelectVersionPresenter, VersionOptionsPresenter, CreatePlayerPresenter, TokenOptionsPresenter, SelectFirstPresenter {

    boolean verifySelectVersionPromptMessageCalled = false;
    boolean verifyVersionCreatedMessage = false;
    boolean verifyPlayerCreatedMessage = false;
    boolean verifyAvailableTokensMessage = false;
    boolean verifyAvailableVersionsMessageCalled = false;
    boolean verifyPlayerSelectedToGoFirstMessage = false;
    boolean verifyCreatePlayerPromptMessageFewerThanMinimum = false;
    boolean verifyCreatePlayerPromptMessageMinimumToMaximum = false;

    @Override
    public void selectVersionPromptMessage() {
        verifySelectVersionPromptMessageCalled = true;
    }

    @Override
    public void versionCreatedMessage(SelectVersionResponse response) {
        verifyVersionCreatedMessage = true;
    }

    @Override
    public void availableVersionsMessage(VersionOptionsResponse response) {
        verifyAvailableVersionsMessageCalled = true;
    }

    @Override
    public void playerCreatedMessage(CreatePlayerResponse response) {
        verifyPlayerCreatedMessage = true;
    }

    @Override
    public void createPlayerPromptMessageFewerThanMinimum() {
        verifyCreatePlayerPromptMessageFewerThanMinimum = true;
    }

    @Override
    public void createPlayerPromptMessageMinimumToMaximum() {
        verifyCreatePlayerPromptMessageMinimumToMaximum = true;
    }

    @Override
    public void availableTokensMessage(TokenOptionsResponse response) {
        verifyAvailableTokensMessage = true;
    }

    @Override
    public void playerSelectedToGoFirstMessage(SelectFirstResponse response) {
        verifyPlayerSelectedToGoFirstMessage = true;
    }
}
