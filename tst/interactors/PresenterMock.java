package game.interactors;

import game.entities.Dice;
import game.interactors.partneroptions.PartnerOptionsResponse;
import game.interactors.propertyoptions.PropertyOptionsResponse;
import game.interactors.selectfirst.SelectFirstResponse;
import game.interactors.tokenoptions.TokenOptionsResponse;
import game.interactors.versionoptions.VersionOptionsResponse;
import game.presenters.Presenter;

class PresenterMock extends Presenter {

    boolean verifySelectVersionPromptMessageCalled = false;
    boolean verifyAvailableVersionsMessageCalled = false;
    boolean verifyVersionCreatedMessage = false;
    boolean verifyCreatePlayerPromptMessageFewerThanMinimumMessage = false;
    boolean verifyCreatePlayerPromptMessageMinimumToMaximumMessage = false;
    boolean verifyAvailableTokensMessage = false;
    boolean verifyPlayerCreatedMessage = false;
    boolean verifyPlayerSelectedToGoFirstMessage = false;
    boolean verifySelectPropertyPromptMessageCalled = false;
    boolean verifyPropertyOptionsMessageCalled = false;
    boolean verifySelectTradingPartnerPromptMessageCalled = false;
    boolean verifyPartnerOptionsMessageCalled = false;

    @Override
    public void selectVersionPromptMessage() {
        verifySelectVersionPromptMessageCalled = true;
    }

    @Override
    public void availableVersionsMessage(VersionOptionsResponse response) {
        verifyAvailableVersionsMessageCalled = true;
    }

    @Override
    public void versionCreatedMessage(VersionOptionsResponse response) {
        verifyVersionCreatedMessage = true;
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
    public void playerCreatedMessage(TokenOptionsResponse response) {
        verifyPlayerCreatedMessage = true;
    }

    @Override
    public void playerSelectedToGoFirstMessage(SelectFirstResponse response) {
        verifyPlayerSelectedToGoFirstMessage = true;
    }

    @Override
    public void startTurnMessage() {
    }

    @Override
    public void rollMessage(Dice dice) {

    }

    @Override
    public void selectPropertyPromptMessage() {
        verifySelectPropertyPromptMessageCalled = true;
    }

    @Override
    public void propertyOptionsMessage(PropertyOptionsResponse response) {
        verifyPropertyOptionsMessageCalled = true;
    }

    @Override
    public void selectTradingPartnerPromptMessage() {
        verifySelectTradingPartnerPromptMessageCalled = true;
    }

    @Override
    public void partnerOptionsMessage(PartnerOptionsResponse response) {
        verifyPartnerOptionsMessageCalled = true;
    }
}
