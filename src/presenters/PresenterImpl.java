package game.presenters;

import game.controllers.Presenter;
import game.interactors.createplayer.CreatePlayerPresenter;
import game.interactors.createplayer.CreatePlayerResponse;
import game.interactors.setupgame.SetupGamePresenter;
import game.interactors.setupgame.SetupGameResponse;

import java.util.Arrays;

public class PresenterImpl implements Presenter, CreatePlayerPresenter, SetupGamePresenter {
    private static final String NEW_LINE = System.lineSeparator();
    String template;
    String[] variables;
    private StringBuffer messageBuffer = new StringBuffer();

    public String getFormattedMessage() {
        String result = messageBuffer.toString();
        messageBuffer = new StringBuffer();
        return result;
    }

    void addMenuToBuffer(String template, String[] variables) {
        sortArray(variables);
        String[] menuItems = createMenuArray(variables);
        addMessageToBuffer(template, menuItems);
    }

    void addMessageToBuffer(String template, String[] variables) {
        sortArray(variables);
        String variable = arrayToCommaDelimitedString(variables);
        String formattedMessage = formatMessage(template, variable);
        addMessageToBuffer(formattedMessage);
    }

    void addMessageToBuffer(String message) {
        String newLine = addNewLine(message);
        messageBuffer.append(newLine);
    }

    private void sortArray(String[] variables) {
        Arrays.sort(variables);
    }

    private String[] createMenuArray(String[] variables) {
        String[] menuItems = new String[variables.length];
        for (int i = 1; i <= variables.length; i++) {
            menuItems[i - 1] = String.format("(%d)%s", i, variables[i - 1]);
        }
        return menuItems;
    }

    private String arrayToCommaDelimitedString(CharSequence[] array) {
        return String.join(", ", array);
    }

    private String formatMessage(String template, String variable) {
        return String.format(template, variable);
    }

    private String addNewLine(String string) {
        return String.format(string + "%s", NEW_LINE);
    }

    @Override
    public void playerCreatedMessage(CreatePlayerResponse response) {

    }

    @Override
    public void tokenInUseMessage(CreatePlayerResponse response) {

    }

    @Override
    public void exceededPlayerLimitMessage() {

    }

    @Override
    public void createPlayerPromptMessage() {

    }

    @Override
    public void availableTokensMessage(CreatePlayerResponse response) {

    }

    @Override
    public void setupGamePromptMessage() {

    }

    @Override
    public void versionCreatedMessage(SetupGameResponse response) {

    }

    @Override
    public void availableVersionsMessage(SetupGameResponse response) {

    }
}
