package game.presenters;

import game.controllers.ControllerPresenter;
import game.display.Console;
import game.interactors.movetoken.MoveTokenPresenter;
import game.interactors.movetoken.MoveTokenResponse;
import game.interactors.partneroptions.PartnerOptionsPresenter;
import game.interactors.propertyoptions.PropertyOptionsPresenter;
import game.interactors.propertyoptions.PropertyOptionsResponse;
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
        PropertyOptionsPresenter, PartnerOptionsPresenter, MoveTokenPresenter {

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
        for (Map.Entry item : menuMap.entrySet()) {
            menuItems[--counter] = String.format("(%d)%s", item.getKey(), item.getValue());
        }
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

    void addNewLine(String formattedMessage) {
        String newLine = String.format(formattedMessage + "%s", NEW_LINE);
        addMessageToBuffer(newLine);
    }

    private void addMessageToBuffer(String newLine) {
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
    public abstract void rollMessage(MoveTokenResponse dice);

    @Override
    public abstract void selectPropertyPromptMessage();

    @Override
    public abstract void propertyOptionsMessage(PropertyOptionsResponse response);

}
