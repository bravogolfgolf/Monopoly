package game.controllers;

import game.interactors.movetoken.MoveTokenResponse;
import game.interactors.partneroptions.PartnerOptionsResponse;
import game.interactors.propertyoptions.PropertyOptionsResponse;
import game.interactors.selectfirst.SelectFirstResponse;
import game.interactors.tokenoptions.TokenOptionsResponse;
import game.interactors.versionoptions.VersionOptionsResponse;
import game.presenters.Presenter;

import java.util.Hashtable;
import java.util.Map;

class PresenterMock extends Presenter {

    boolean verifyGetMenuMapCalled = false;
    boolean verifyGetFormattedMessageCalled = false;
    boolean verifyStartTurnMessageCalled = false;

    @Override
    public String getFormattedMessage() {
        verifyGetFormattedMessageCalled = true;
        return null;
    }

    @Override
    public void startTurnMessage() {
        verifyStartTurnMessageCalled = true;
    }

    @Override
    public void rollMessage(MoveTokenResponse dice) {
    }

    @Override
    public void moveMessage(MoveTokenResponse response) {

    }

    @Override
    public void selectPropertyPromptMessage() {

    }

    @Override
    public void propertyOptionsMessage(PropertyOptionsResponse response) {

    }

    @Override
    public Map<Integer, String> returnAndClearMenuMap() {
        verifyGetMenuMapCalled = true;
        return new Hashtable<Integer, String>() {{
            put(1, "USA");
        }};
    }

    @Override
    public void selectVersionPromptMessage() {

    }

    @Override
    public void availableVersionsMessage(VersionOptionsResponse response) {

    }

    @Override
    public void versionCreatedMessage(VersionOptionsResponse response) {

    }

    @Override
    public void createPlayerPromptMessageFewerThanMinimumMessage() {

    }

    @Override
    public void createPlayerPromptMessageMinimumToMaximumMessage() {

    }

    @Override
    public void availableTokensMessage(TokenOptionsResponse response) {

    }

    @Override
    public void playerCreatedMessage(TokenOptionsResponse response) {

    }

    @Override
    public void playerSelectedToGoFirstMessage(SelectFirstResponse response) {

    }

    @Override
    public void selectTradingPartnerPromptMessage() {

    }

    @Override
    public void partnerOptionsMessage(PartnerOptionsResponse response) {

    }
}
