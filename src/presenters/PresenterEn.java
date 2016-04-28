package game.presenters;

import game.interactors.partneroptions.PartnerOptionsResponse;
import game.interactors.propertyoptions.PropertyOptionsResponse;
import game.interactors.selectfirst.SelectFirstResponse;
import game.interactors.tokenoptions.TokenOptionsResponse;
import game.interactors.versionoptions.VersionOptionsResponse;

public class PresenterEn extends Presenter {

    @Override
    public void selectVersionPromptMessage() {
        template = "\nSelect version of game you would like to play.";
        addNewLine(template);
    }

    @Override
    public void availableVersionsMessage(VersionOptionsResponse response) {
        template = "Available versions: %s";
        variables = response.versions;
        clearAndCreateMenuMap(variables);
        addMenuToBuffer(template, menuMap);
    }

    @Override
    public void versionCreatedMessage(VersionOptionsResponse response) {
        template = "\n%s version of game created.";
        variables = new String[]{response.version};
        addMessageToBuffer(template, variables);
    }

    @Override
    public void createPlayerPromptMessageFewerThanMinimumMessage() {
        template = "\nPlease select token for player. (Players 2 - 8)";
        addNewLine(template);
    }

    @Override
    public void createPlayerPromptMessageMinimumToMaximumMessage() {
        template = "\nPlease select token for player or (0)Play to begin. (Players 2 - 8)";
        addNewLine(template);
    }

    @Override
    public void availableTokensMessage(TokenOptionsResponse response) {
        template = "Available tokens: %s";
        clearAndCreateMenuMap(response.tokens);
        addMenuToBuffer(template, menuMap);
    }

    @Override
    public void playerCreatedMessage(TokenOptionsResponse response) {
        template = "\nPlayer created with %s token.";
        variables = new String[]{response.token};
        addMessageToBuffer(template, variables);
    }

    @Override
    public void playerSelectedToGoFirstMessage(SelectFirstResponse response) {
        template = "\n%s selected to go first.";
        variables = new String[]{response.token};
        addMessageToBuffer(template, variables);
    }

    @Override
    public void startTurnMessage() {
        template = "\nAvailable options: (0)Roll (1)Manage Properties (2)Trade.";
        addNewLine(template);
    }

    @Override
    public void selectPropertyPromptMessage() {
        template = "\nSelect property to manage or (0)Done to return to previous menu.";
        addNewLine(template);
    }

    @Override
    public void propertyOptionsMessage(PropertyOptionsResponse response) {
        template = "No properties to manage.";
        addNewLine(template);
    }

    @Override
    public void selectTradingPartnerPromptMessage() {
        template = "\nSelect player to trade with or (0)Done to return to previous menu.";
        addNewLine(template);
    }

    @Override
    public void partnerOptionsMessage(PartnerOptionsResponse response) {
        template = "Available trading partners: %s";
        clearAndCreateMenuMap(response.players);
        addMenuToBuffer(template, menuMap);
    }
}