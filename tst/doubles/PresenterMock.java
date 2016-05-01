package game.doubles;

import game.display.Console;
import game.interactors.movetoken.MoveTokenResponse;
import game.interactors.partneroptions.PartnerOptionsResponse;
import game.interactors.propertyoptions.PropertyOptionsResponse;
import game.interactors.selectfirst.SelectFirstResponse;
import game.interactors.tokenoptions.TokenOptionsResponse;
import game.interactors.versionoptions.VersionOptionsResponse;
import game.parser.Parser;
import game.presenters.Presenter;

public class PresenterMock extends Presenter {

    public boolean verifySelectVersionPromptMessageCalled = false;
    public boolean verifyAvailableVersionsMessageCalled = false;
    public boolean verifyVersionCreatedMessage = false;
    public boolean verifyCreatePlayerPromptMessageFewerThanMinimumMessage = false;
    public boolean verifyCreatePlayerPromptMessageMinimumToMaximumMessage = false;
    public boolean verifyAvailableTokensMessage = false;
    public boolean verifyPlayerCreatedMessage = false;
    public boolean verifyPlayerSelectedToGoFirstMessage = false;
    public boolean verifySelectPropertyPromptMessageCalled = false;
    public boolean verifyPropertyOptionsMessageCalled = false;
    public boolean verifySelectTradingPartnerPromptMessageCalled = false;
    public boolean verifyPartnerOptionsMessageCalled = false;
    public boolean verifyRollMessageCalled = false;
    public boolean verifyMoveMessageCalled = false;
    public boolean verifyStartTurnMessageCalled = false;
    public boolean verifyWriteMessageCalled = false;

    public PresenterMock(Console console, Parser parser) {
        super(console, parser);
    }


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
        verifyStartTurnMessageCalled = true;
    }

    @Override
    public void rollMessage(MoveTokenResponse dice) {
        verifyRollMessageCalled = true;
    }

    @Override
    public void moveMessage(MoveTokenResponse response) {
        verifyMoveMessageCalled = true;
    }

    @Override
    public void selectPropertyPromptMessage() {
        verifySelectPropertyPromptMessageCalled = true;
    }

    @Override
    public void writeMessage() {
        verifyWriteMessageCalled = true;
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
