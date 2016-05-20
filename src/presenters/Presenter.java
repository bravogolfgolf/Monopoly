package game.presenters;

import game.controllers.ControllerPresenter;
import game.display.Console;
import game.interactors.communitychest.DrawCommunityChestCardPresenter;
import game.interactors.communitychest.DrawCommunityChestCardResponse;
import game.interactors.gotojail.GoToJailPresenter;
import game.interactors.gotojail.GoToJailResponse;
import game.interactors.incometax.CollectIncomeTaxPresenter;
import game.interactors.incometax.CollectIncomeTaxResponse;
import game.interactors.landon.LandOnPresenter;
import game.interactors.landon.LandOnResponse;
import game.interactors.luxurytax.CollectLuxuryTaxPresenter;
import game.interactors.movetoken.MoveTokenPresenter;
import game.interactors.movetoken.MoveTokenResponse;
import game.interactors.partneroptions.PartnerOptionsPresenter;
import game.interactors.partneroptions.PartnerOptionsResponse;
import game.interactors.paysalary.PaySalaryPresenter;
import game.interactors.propertyoptions.PropertyOptionsPresenter;
import game.interactors.propertyoptions.PropertyOptionsResponse;
import game.interactors.rolldice.RollDicePresenter;
import game.interactors.rolldice.RollDiceResponse;
import game.interactors.selectfirst.SelectFirstPresenter;
import game.interactors.selectfirst.SelectFirstResponse;
import game.interactors.tokenoptions.TokenOptionsPresenter;
import game.interactors.tokenoptions.TokenOptionsResponse;
import game.interactors.versionoptions.VersionOptionsPresenter;
import game.interactors.versionoptions.VersionOptionsResponse;
import game.parser.Parser;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

public abstract class Presenter implements ControllerPresenter,
        VersionOptionsPresenter, TokenOptionsPresenter, SelectFirstPresenter,
        PropertyOptionsPresenter, PartnerOptionsPresenter, RollDicePresenter,
        MoveTokenPresenter, PaySalaryPresenter, LandOnPresenter, CollectIncomeTaxPresenter,
        CollectLuxuryTaxPresenter, DrawCommunityChestCardPresenter, GoToJailPresenter {

    private final PresenterConsole console;
    private final PresenterParser parser;
    private static final String NEW_LINE = System.lineSeparator();
    private StringBuffer messageBuffer = new StringBuffer();
    final Map<Integer, String> menuMap = new Hashtable<>();
    String template;
    String[] variables;

    public Presenter(Console console, Parser parser) {
        this.console = console;
        this.parser = parser;
    }

    @Override
    public void writeMessage() throws IOException {
        writeToParser();
        writeToConsole();
    }

    private void writeToConsole() throws IOException {
        String result = messageBuffer.toString();
        messageBuffer = new StringBuffer();
        console.write(result);
    }

    private void writeToParser() {
        Map<Integer, String> result = new Hashtable<>(menuMap);
        menuMap.clear();
        parser.setMap(result);
    }

    void createMenuMap(String[] strings) {
        int counter = 1;
        for (String string : strings) {
            menuMap.put(counter++, string);
        }
    }

    void addMenuToBuffer(String template, Map map) {
        variables = createMenuArray(map);
        addMessageToBuffer(template, variables);
    }

    private String[] createMenuArray(Map map) {
        String[] menuItems = new String[map.size()];
        int counter = map.size();
        for (Map.Entry item : menuMap.entrySet())
            menuItems[--counter] = String.format("(%s)%s", item.getKey().toString(), item.getValue());
        return menuItems;
    }

    void addMessageToBuffer(String template, String[] variables) {
        String variable = arrayToCommaDelimitedString(variables);
        formatMessage(template, variable);
    }

    private String arrayToCommaDelimitedString(CharSequence[] array) {
        return String.join(", ", array);
    }

    private void formatMessage(String template, String variable) {
        String formattedMessage = String.format(template, variable);
        addNewLine(formattedMessage);
    }

    void addMessageToBuffer(String template) {
        String formattedMessage = String.format("%s" + template, NEW_LINE);
        addNewLine(formattedMessage);
    }

    private void addNewLine(String formattedMessage) {
        String newLine = String.format(formattedMessage + "%s", NEW_LINE);
        messageBuffer.append(newLine);
    }

    @Override
    public abstract void selectVersionPromptMessage();

    @Override
    public abstract void availableVersionsMessage(VersionOptionsResponse response);

    @Override
    public abstract void createPlayerPromptMessageFewerThanMinimumMessage();

    @Override
    public abstract void createPlayerPromptMessageMinimumToMaximumMessage();

    @Override
    public abstract void availableTokensMessage(TokenOptionsResponse response);

    @Override
    public abstract void playerSelectedToGoFirstMessage(SelectFirstResponse response);

    @Override
    public abstract void startTurnMessage();

    @Override
    public abstract void rollMessage(RollDiceResponse dice);

    @Override
    public abstract void selectPropertyPromptMessage();

    @Override
    public abstract void propertyOptionsMessage(PropertyOptionsResponse response);

    @Override
    public abstract void landOnMessage(LandOnResponse response);

    @Override
    public abstract void goToJailMessage(GoToJailResponse response);

    @Override
    public abstract void collectIncomeTaxMessage(CollectIncomeTaxResponse response);

    @Override
    public abstract void passGoMessage(MoveTokenResponse response);

    @Override
    public abstract void selectTradingPartnerPromptMessage();

    @Override
    public abstract void partnerOptionsMessage(PartnerOptionsResponse response);

    @Override
    public abstract void paySalaryMessage();

    @Override
    public abstract void playerCreatedMessage(TokenOptionsResponse response);

    @Override
    public abstract void versionCreatedMessage(VersionOptionsResponse response);

    @Override
    public abstract void collectLuxuryTaxMessage();

    @Override
    public abstract void cardMessage(DrawCommunityChestCardResponse response);
}
