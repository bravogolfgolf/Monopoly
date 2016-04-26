package game.interactors;

import game.interactors.createplayer.CreatePlayerPresenter;
import game.interactors.createplayer.CreatePlayerResponse;
import game.interactors.selectfirst.SelectFirstPresenter;
import game.interactors.selectfirst.SelectFirstResponse;
import game.interactors.selectversion.SelectVersionPresenter;
import game.interactors.selectversion.SelectVersionResponse;
import game.interactors.tokenoptions.TokenOptionsPresenter;
import game.interactors.tokenoptions.TokenOptionsResponse;
import game.interactors.versionoptions.VersionOptionsPresenter;
import game.interactors.versionoptions.VersionOptionsResponse;

class PresenterMock implements SelectVersionPresenter, VersionOptionsPresenter, CreatePlayerPresenter, TokenOptionsPresenter, SelectFirstPresenter {

    boolean verifySelectVersionPromptMessageCalled = false;
    boolean verifyVersionCreatedMessage = false;
    boolean verifyAvailableVersionsMessageCalled = false;
    boolean verifyPlayerCreatedMessage = false;
    boolean verifyCreatePlayerPromptMessageFewerThanMinimumMessage = false;
    boolean verifyCreatePlayerPromptMessageMinimumToMaximumMessage = false;
    boolean verifyAvailableTokensMessage = false;
    boolean verifyPlayerSelectedToGoFirstMessage = false;

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
    public void createPlayerPromptMessageFewerThanMinimumMessage() {
        verifyCreatePlayerPromptMessageFewerThanMinimumMessage = true;
    }

    @Override
    public void createPlayerPromptMessageMinimumToMaximumMessage() {
        verifyCreatePlayerPromptMessageMinimumToMaximumMessage = true;
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
